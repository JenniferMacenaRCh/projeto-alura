function adicionarAmigo() {
    const input = document.getElementById('amigo');
    const nome = input.value.trim();

    if (nome === '') {
        alert('Por favor, digite um nome válido.');
        return;
    }

    const listaAmigos = document.getElementById('listaAmigos');
    const itemLista = document.createElement('li');
    itemLista.textContent = nome;
    listaAmigos.appendChild(itemLista);

    input.value = '';
}

function sortearAmigo() {
    const listaAmigos = document.getElementById('listaAmigos');
    const itens = listaAmigos.getElementsByTagName('li');

    if (itens.length < 2) {
        alert('Adicione pelo menos 2 nomes para sortear.');
        return;
    }

    const nomes = Array.from(itens).map(li => li.textContent);
    const resultado = document.getElementById('resultado');
    resultado.innerHTML = '';

    const nomesEmbaralhados = embaralhar(nomes);

    for (let i = 0; i < nomesEmbaralhados.length; i++) {
        const amigoSecreto = nomesEmbaralhados[(i + 1) % nomesEmbaralhados.length];
        const itemResultado = document.createElement('li');
        itemResultado.textContent = `${nomesEmbaralhados[i]} ➔ ${amigoSecreto}`;
        resultado.appendChild(itemResultado);
    }
}

function embaralhar(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
}
