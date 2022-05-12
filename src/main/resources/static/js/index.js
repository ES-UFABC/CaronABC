function emailEhValido(email) {
    const re = /^[^ \t\n\f\r]+@(aluno\.)?ufabc\.edu\.br$/;

    var ehValido = re.test(email);
    return ehValido;
}

var email = "g.braz@ufabc.edu.br";
var verifica = emailEhValido(email);

console.log(verifica);