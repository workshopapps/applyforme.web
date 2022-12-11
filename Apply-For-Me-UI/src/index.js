import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
// import * as Sentry from "@sentry/react";
// import { BrowserTracing } from "@sentry/tracing";
import App from "./App";
import store from "store";
import { Provider } from "react-redux";
import { AppProvider } from "./hooks/context";
import reportWebVitals from "./reportWebVitals";
import { BrowserRouter } from "react-router-dom";

/*
process.env.NODE_ENV == "production" & Sentry.init({
    dsn: "https://0ef21b8dab334de1b46971b24fd0c943@o4504282479919104.ingest.sentry.io/4504282505216001",
    integrations: [new BrowserTracing()],
  
    // Set tracesSampleRate to 1.0 to capture 100%
    // of transactions for performance monitoring.
    // We recommend adjusting this value in production
    tracesSampleRate: 1.0,
  });
  */

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
    <AppProvider>
        {/*<React.StrictMode>*/}
        <Provider store={store}>
            <BrowserRouter>
                <App />
            </BrowserRouter>
        </Provider>
        {/* </React.StrictMode>*/}
    </AppProvider>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
