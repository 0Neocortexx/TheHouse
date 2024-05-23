import mock from '@/@fake-db/mock'
import type { ProjectsAnalytics } from '@/@fake-db/types'
import { paginateArray } from '@/@fake-db/utlis'
import avatar2 from '@images/avatars/avatar-2.png'
import avatar3 from '@images/avatars/avatar-3.png'
import avatar4 from '@images/avatars/avatar-4.png'
import avatar5 from '@images/avatars/avatar-5.png'

const database: ProjectsAnalytics[] = [
  {
    logo: '',
    name: 'Website SEO',
    date: '10 May 2021',
    leader: 'Eileen',
    team: [avatar5, avatar2, avatar3, avatar4],
    status: 38,
  }
]

mock.onGet('/dashboard/analytics/projects').reply(config => {
  const { q = '', perPage = 0, currentPage = 1 } = config.params ?? {}

  const queryLowered = q.toLowerCase()

  const filteredProjects = database.filter(project => (
    (project.name.toLowerCase().includes(queryLowered) || project.leader.toLowerCase().includes(queryLowered))),
  )

  const totalPage = Math.ceil(filteredProjects.length / perPage) ? Math.ceil(filteredProjects.length / perPage) : 1
  const totalProjects = filteredProjects.length

  return [200, { projects: paginateArray(filteredProjects, perPage, currentPage), totalPage, totalProjects }]
})
