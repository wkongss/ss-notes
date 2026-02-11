import { useState } from "react"
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import ContextComponent from "./components/ContextComponent";
import AnotherIntermediateComponent from "./components/AnotherIntermediateComponent";
import IntermediateComponent from "./components/IntermediateComponent";
import { TextContext } from "./contexts/MyContext";

import "./App.css"
import "bootstrap/dist/css/bootstrap.min.css";
import JSXDisplay from "./components/JSXDisplay";

const appCode =
  `...
<TextContext value={text}>
  <ContextComponent />
  <IntermediateComponent />
  <AnotherIntermediateComponent />
</TextContext>
...`;

const componentCode =
`export default function ContextComponent() {
    const textValue = useContext(TextContext);
    return (
        <Card>
            <Card.Header>
                Context Component
            </Card.Header>
            <Card.Body>
                {textValue}
            </Card.Body>
        </Card>
    );
}
`

function App() {
  const [text, setText] = useState("");

  return (
    <Container>
      <h1>
        Context Demo
      </h1>
      <Row className="p-3">
        <Col md={6} className="border p-3">
          <Form action={"#"} onSubmit={(e) => {
            e.preventDefault();
          }}
          >
            <h4>
              Set Context
            </h4>
            <Form.Group className="mb-3" controlId="formText">
              <Form.Control
                value={text}
                onChange={(e) => {
                  setText(e.target.value);
                }}
              />
            </Form.Group>
          </Form>

          <h4>
            App.jsx
          </h4>
          <JSXDisplay codeString={appCode} />

          <h4>
            ContextComponent.jsx
          </h4>
          <JSXDisplay codeString={componentCode} />
        </Col>

        <Col md={6} className="border p-5">
          <TextContext value={text}>
            <ContextComponent />
            <IntermediateComponent />
            <AnotherIntermediateComponent />
          </TextContext>
        </Col>
      </Row>
    </Container>
  );
}

export default App
