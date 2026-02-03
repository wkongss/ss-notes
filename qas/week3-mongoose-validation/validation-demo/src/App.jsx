import { useState, useEffect } from "react";
import mongoose from "mongoose";
import "dotenv/config";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

import CSSDisplay from "../components/CSSDisplay";
import Control from "../components/Control";
import Flex from "../components/Flex";

import "./App.css"
import "bootstrap/dist/css/bootstrap.min.css";

useEffect(async () => {
  try {
    const dbUrl = process.env.MONGO_URL;
    await mongoose.connect(dbUrl);
  } catch (error) {
    console.error(error);
  }
}, []);

function App() {
  return (
    <Container>
      <h1>
        Flexbox Demo
      </h1>
      <Row className="p-3">
        <Col md={6} className="bg-light border">
          <Row className="border-bottom p-3">
            <Control
              propList={propList}
              updateStyle={updateStyle}
            />
          </Row>
          <Row className="p-3">
            <h4>
              CSS
            </h4>
            <CSSDisplay
              codeString={codestring} />
          </Row>
        </Col>

        <Col md={6} className="bg-light border">
          <Flex
            style={flexStyle}
            boxList={boxList}
          />
        </Col>
      </Row>
    </Container>
  );
}

export default App
