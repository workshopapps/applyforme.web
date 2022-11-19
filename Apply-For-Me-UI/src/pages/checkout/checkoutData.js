import warning from "assets/images/warning.png";
import backwards from "assets/images/goback.png";

export const formData = {
  goBack: "Back to all plans",
  warning: warning,
  backwards: backwards,
  heading: "Please add your payment information to continue",
  pinDetails: {
    label: "Card number",
    placeholder: "1234 5678 9101 1121",
    type: "number",
    naming: "pin"
  },
  cred: "invalid credential",

  userCred: {
    label: "Cardholder's name",
    placeholder: "Kanyinsola George",
    type: "text",
    naming: "userCred"
  },
  validity: {
    label: "Expiration date",
    yearPlaceholder: "MM",
    monthPlaceholder: "YR"
  },
  cvv: {
    label: "CVV",
    placeholder: "XXX"
  },
  btnText: "Make payment",
  terms:
    "I understard that this membership subcription would automatically autorenew and would continue untill I cancel "
};
