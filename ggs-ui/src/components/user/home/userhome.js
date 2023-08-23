import React from "react";
import "./styles/home.css";
import CountdownTimer from "./CountdownTimer";
import { Button } from 'semantic-ui-react'

export default function UserHome() {
  const releaseDate = new Date('October 1, 2023 12:00:00');
  return (
    <div class = "main">
      <h1>Coming Soon...</h1>
      <h2>Thank you for being one of the first to Golden Guardian Solutions!</h2>
      <h3>We will be releasing on October 1st at 12:00pm</h3>
      <CountdownTimer targetDate={releaseDate} />
      <h3>Click the button below to be considered for Beta Access</h3>
      <Button primary>Request Beta Access</Button>

    </div>
  );
}
