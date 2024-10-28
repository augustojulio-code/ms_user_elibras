
function fetchCoverageData() {
    fetch('/api/sonarcloud/coverage')
        .then(response => response.text())
        .then(data => {
            document.getElementById('coverage-data').innerText = data;
        })
        .catch(error => console.error("Erro ao buscar dados:", error));
}
window.onload = fetchCoverageData;