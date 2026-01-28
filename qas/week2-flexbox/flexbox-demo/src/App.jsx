import { useState } from "react"
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";

import CSSDisplay from "../components/CSSDisplay";
import Control from "../components/Control";
import Flex from "../components/Flex";

import "./App.css"
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const propList = [
    ["flexDirection", ["row", "row-reverse", "column", "column-reverse"]],
    ["justifyContent", ["flex-start", "center", "flex-end", "space-evenly"]],
    ["alignItems", ["flex-start", "center", "flex-end", "stretch"]],
    ["flexWrap", ["nowrap", "wrap"]]
  ];

  const [flexStyle, setFlexStyle] = useState(() => {
    return {
      "display": "flex",
      "flexDirection": "row",
      "justifyContent": "flex-start",
      "alignItems": "flex-start",
      "flexWrap": "nowrap",
      "height": "550px"
    };
  })

  const codestring =
    `.container {
    display: ${flexStyle["display"]};
    flex-direction: ${flexStyle["flexDirection"]};
    justify-content: ${flexStyle["justifyContent"]};
    align-items: ${flexStyle["alignItems"]};
    flex-wrap: ${flexStyle["flexWrap"]};\n}`;

  function updateStyle(prop, value) {
    setFlexStyle((prev) => {
      return {
        ...prev,
        [prop]: value
      }
    })
  }

  const size = flexStyle["flexWrap"] === "wrap" ? "160px" : "70px";

  const boxList = Array.from({ length: 6 }, (_, i) => (
    <Card
      key={`card-${i}`}
      style={{
        "min-width": size,
        "min-height": size,
        display: "flex",
        justifyContent: "center",
        alignItems: "center"
      }}>
      <Card.Body>
        <h3>
          {i + 1}
        </h3>
      </Card.Body>
    </Card>
  ))

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
