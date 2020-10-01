class LogoutForm {
  constructor() {
    const logOutForm = document.getElementById("logout-form");
    const logoutButton = document.getElementById("logout-button");

    logoutButton.addEventListener("click", (e) => {
      e.preventDefault();
      logOutForm.submit();
    });
  }
}

export default LogoutForm;
