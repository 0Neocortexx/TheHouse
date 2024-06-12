document.addEventListener('DOMContentLoaded', (event) => {
    const trazerFinancas = () => {
        fetch('http://localhost:8085/api/financa/list')
            .then((response) => response.json())
            .then((data) => {
                createTable(data);
                showModal();
            })
            .catch((error) => console.log(error));
    };

    const trazerMetas = () => {
        fetch('http://localhost:8085/api/meta/list')
            .then((response) => response.json())
            .then((data) => {
                createTable(data);
                showModal();
            })
            .catch((error) => console.log(error));
    };

    const createTable = (data) => {
        const modalContent = document.getElementById('modal-content');
        let tableHtml = '<table class="table table-striped">';
        tableHtml += '<thead><tr>';

        // Assume o primeiro item na array de dados contém todas as chaves necessárias para o cabeçalho
        const headers = Object.keys(data[0]);
        headers.forEach((header) => {
            tableHtml += `<th>${header}</th>`;
        });
        tableHtml += '</tr></thead><tbody>';

        // Gerar linhas da tabela
        data.forEach((item) => {
            tableHtml += '<tr>';
            headers.forEach((header) => {
                tableHtml += `<td>${item[header]}</td>`;
            });
            tableHtml += '</tr>';
        });

        tableHtml += '</tbody></table>';
        modalContent.innerHTML = tableHtml;
    };

    const showModal = () => {
        const modal = new bootstrap.Modal(document.getElementById('dataModal'));
        modal.show();
    };

    document.getElementById('ver-financas').addEventListener('click', function(event) {
        event.preventDefault();
        trazerFinancas();
    });

    document.getElementById('metas').addEventListener('click', function(event) {
        event.preventDefault();
        trazerMetas();
    });
});
