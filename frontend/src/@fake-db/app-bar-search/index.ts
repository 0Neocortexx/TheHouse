// ** Mock Adapter
import mock from '@/@fake-db/mock'

// ** Types
import type { SearchHeader, SearchItem } from '@/@fake-db/types'

const database: SearchItem[] = [
  {
    id: 4,
    url: { name: 'apps-email' },
    icon: 'tabler-mail',
    title: 'Email',
    category: 'appsPages',
  },
  {
    id: 5,
    url: { name: 'apps-chat' },
    icon: 'tabler-message',
    title: 'Chat',
    category: 'appsPages',
  },
  {
    id: 6,
    url: { name: 'apps-calendar' },
    icon: 'tabler-calendar',
    title: 'Calendar',
    category: 'appsPages',
  },
  {
    id: 7,
    url: { name: 'apps-invoice-list' },
    icon: 'tabler-list',
    title: 'Invoice List',
    category: 'appsPages',
  },
  {
    id: 8,
    url: { name: 'apps-invoice-preview' },
    icon: 'tabler-file-description',
    title: 'Invoice Preview',
    category: 'appsPages',
  },
  {
    id: 9,
    url: { name: 'apps-invoice-edit' },
    icon: 'tabler-file-pencil',
    title: 'Invoice Edit',
    category: 'appsPages',
  },
  {
    id: 10,
    url: { name: 'apps-invoice-add' },
    icon: 'tabler-file-plus',
    title: 'Invoice Add',
    category: 'appsPages',
  },
  {
    id: 11,
    url: { name: 'apps-user-list' },
    icon: 'tabler-user',
    title: 'User List',
    category: 'appsPages',
  },
  {
    id: 12,
    url: { name: 'apps-user-view-id', params: { id: 21 } },
    icon: 'tabler-eye',
    title: 'User View - Overview',
    category: 'appsPages',
  },
  {
    id: 13,
    url: { name: 'pages-help-center' },
    icon: 'tabler-help',
    title: 'Help Center',
    category: 'appsPages',
  },
  {
    id: 23,
    url: { name: 'pages-user-profile-tab', params: { tab: 'profile' } },
    icon: 'tabler-user',
    title: 'User Profile - Profile',
    category: 'appsPages',
  },
  {
    id: 23,
    url: { name: 'pages-account-settings-tab', params: { tab: 'account' } },
    icon: 'tabler-user',
    title: 'Account Settings - Account',
    category: 'appsPages',
  },
  {
    id: 24,
    url: { name: 'pages-account-settings-tab', params: { tab: 'security' } },
    icon: 'tabler-lock-open',
    title: 'Account Settings - Security',
    category: 'appsPages',
  },
  {
    id: 25,
    url: { name: 'pages-account-settings-tab', params: { tab: 'billing' } },
    icon: 'tabler-currency-dollar',
    title: 'Account Settings - Billing',
    category: 'appsPages',
  },
  {
    id: 26,
    url: { name: 'pages-account-settings-tab', params: { tab: 'notification' } },
    icon: 'tabler-bell',
    title: 'Account Settings - Notifications',
    category: 'appsPages',
  },
  {
    id: 27,
    url: { name: 'pages-account-settings-tab', params: { tab: 'connection' } },
    icon: 'tabler-link',
    title: 'Account Settings - Connections',
    category: 'appsPages',
  },
  {
    id: 30,
    url: { name: 'pages-pricing' },
    icon: 'tabler-currency-dollar',
    title: 'Pricing',
    category: 'appsPages',
  },
  {
    id: 28,
    url: { name: 'pages-faq' },
    icon: 'tabler-help',
    title: 'FAQ',
    category: 'appsPages',
  },
  {
    id: 31,
    url: { name: 'pages-misc-coming-soon' },
    icon: 'tabler-clock',
    title: 'Coming Soon',
    category: 'appsPages',
  },
  {
    id: 32,
    url: { name: 'pages-misc-under-maintenance' },
    icon: 'tabler-settings',
    title: 'Under Maintenance',
    category: 'appsPages',
  },
  {
    id: 33,
    url: { name: 'pages-misc-not-found' },
    icon: 'tabler-alert-circle',
    title: 'Page Not Found - 404',
    category: 'appsPages',
  },
  {
    id: 34,
    url: { name: 'pages-misc-not-authorized' },
    icon: 'tabler-users',
    title: 'Not Authorized - 401',
    category: 'appsPages',
  },
  {
    id: 35,
    url: { name: 'pages-misc-internal-server-error' },
    icon: 'tabler-list',
    title: 'Server Error - 500',
    category: 'appsPages',
  },
  {
    id: 36,
    url: { name: 'pages-authentication-login-v1' },
    icon: 'tabler-login',
    title: 'Login V1',
    category: 'appsPages',
  },
  {
    id: 37,
    url: { name: 'pages-authentication-login-v2' },
    icon: 'tabler-login',
    title: 'Login V2',
    category: 'appsPages',
  },
  {
    id: 39,
    url: { name: 'pages-authentication-register-v1' },
    icon: 'tabler-user-plus',
    title: 'Register V1',
    category: 'appsPages',
  },
  {
    id: 40,
    url: { name: 'pages-authentication-register-v2' },
    icon: 'tabler-user-plus',
    title: 'Register V2',
    category: 'appsPages',
  },
  {
    id: 42,
    icon: 'tabler-mail',
    category: 'appsPages',
    title: 'Verify Email V1',
    url: { name: 'pages-authentication-verify-email-v1' },
  },
  {
    id: 43,
    icon: 'tabler-mail',
    category: 'appsPages',
    title: 'Verify Email V2',
    url: { name: 'pages-authentication-verify-email-v2' },
  },
  {
    id: 44,
    url: { name: 'pages-authentication-forgot-password-v1' },
    icon: 'tabler-lock',
    title: 'Forgot Password V1',
    category: 'appsPages',
  },
  {
    id: 45,
    url: { name: 'pages-authentication-forgot-password-v2' },
    icon: 'tabler-lock',
    title: 'Forgot Password V2',
    category: 'appsPages',
  },
  {
    id: 46,
    url: { name: 'pages-authentication-reset-password-v1' },
    icon: 'tabler-lock',
    title: 'Reset Password V1',
    category: 'appsPages',
  },
  {
    id: 47,
    url: { name: 'pages-authentication-reset-password-v2' },
    icon: 'tabler-lock',
    title: 'Reset Password V2',
    category: 'appsPages',
  },
  {
    id: 48,
    icon: 'tabler-devices',
    category: 'appsPages',
    title: 'Two Steps V1',
    url: { name: 'pages-authentication-two-steps-v1' },
  },
  {
    id: 49,
    url: { name: 'metas' },
    icon: 'tabler-calendar',
    title: 'Metas',
    category: 'appsPages',
  },
]

// ** GET Search Data
// eslint-disable-next-line sonarjs/cognitive-complexity
mock.onGet('/app-bar/search').reply(config => {
  const { q = '' } = config.params
  const queryLowered = q.toLowerCase()

  const exactData: { [k: string]: SearchItem[] } = {
    dashboards: [],
    appsPages: [],
    userInterface: [],
    formsTables: [],
    chartsMisc: [],
  }

  const includeData: { [k: string]: SearchItem[] } = {
    dashboards: [],
    appsPages: [],
    userInterface: [],
    formsTables: [],
    chartsMisc: [],
  }

  database.forEach(obj => {
    const isMatched = obj.title.toLowerCase().startsWith(queryLowered)
    if (isMatched && exactData[obj.category].length < 5)
      exactData[obj.category].push(obj)
  })

  database.forEach(obj => {
    const isMatched
      = !obj.title.toLowerCase().startsWith(queryLowered) && obj.title.toLowerCase().includes(queryLowered)

    if (isMatched && includeData[obj.category].length < 5)
      includeData[obj.category].push(obj)
  })

  const categoriesCheck: string[] = []

  Object.keys(exactData).forEach(category => {
    if (exactData[category].length > 0)
      categoriesCheck.push(category)
  })
  if (categoriesCheck.length === 0) {
    Object.keys(includeData).forEach(category => {
      if (includeData[category].length > 0)
        categoriesCheck.push(category)
    })
  }

  const resultsLength = categoriesCheck.length === 1 ? 5 : 3

  const mergedData: (SearchItem | SearchHeader)[] = []

  Object.keys(exactData).forEach(element => {
    if (exactData[element].length || includeData[element].length) {
      const r: (SearchItem | SearchHeader)[] = exactData[element].concat(includeData[element]).slice(0, resultsLength)

      r.unshift({ header: element, title: element })

      mergedData.push(...r)
    }
  })

  return [200, [...mergedData]]
})
