const url = "http://localhost:8080/musicas";
function salvar(){
    const musica = {
        nome: document.getElementById("nome").value,
        artista: document.getElementById("artista").value,
        genero: document.getElementById("genero").value,
        duracao: parseFloat(document.getElementById("duracao").value),
        ano: parseInt(document.getElementById("ano").value),
    };

    fetch (url, {method: "POST", headers:{"Content-Type":"application/json"}, body: JSON.stringify(musica)}).then(() => listar());
}

function listar(){
    fetch(url)
    .then(res => res.json())
    .then(dados => {
        const lista = document.getElementById("lista");
        lista.innerHTML = "";

    dados.forEach(musica => {
    const mu = document.createElement("mu");
    mu.innerText = `${musica.nome} - ${musica.artista} - ${musica.genero}`;
    lista.appendChild(mu);
    });
    });
}

listar();