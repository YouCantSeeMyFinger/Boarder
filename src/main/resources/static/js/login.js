function validateForm() {
    const idInput = document.getElementById("id");
    const idValue = idInput.value.trim();

    const passwordInput = document.getElementById("password");
    const passwordValue = passwordInput.value.trim();

    if (idValue === "" || passwordValue === "") {
        alert("아이디 및 패스워드를 입력해주세요.");
        return false;
    }
    return true;
}