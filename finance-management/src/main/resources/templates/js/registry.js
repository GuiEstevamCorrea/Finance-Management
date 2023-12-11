function cadastrarUsuario() {
  var form = document.getElementById("userForm");
  var formData = new FormData(form);

  // Serializa os dados do formulário como JSON
  var jsonData = {};
  formData.forEach((value, key) => {
      jsonData[key] = value;
  });

  var xhr = new XMLHttpRequest();
  xhr.open("POST", "http://localhost:8080/users", true);
  xhr.setRequestHeader("Content-Type", "application/json");
  xhr.onreadystatechange = function () {
      if (xhr.readyState == 4) {
          if (xhr.status == 201) {
              form.reset();
              alert("Usuário cadastrado com sucesso!");
          } else if (xhr.status == 400) {
              console.error("Erro ao cadastrar usuário: " + xhr.responseText);
              alert("Erro ao cadastrar usuário. Verifique os dados e tente novamente.");
          } else {
              console.error("Erro desconhecido ao cadastrar usuário. Status: " + xhr.status);
              alert("Erro desconhecido ao cadastrar usuário. Tente novamente mais tarde.");
          }
      }
  };

  xhr.send(JSON.stringify(jsonData));
}