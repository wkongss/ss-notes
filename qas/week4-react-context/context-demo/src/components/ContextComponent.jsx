import { useContext } from "react";
import { TextContext } from "../contexts/MyContext";
import Card from "react-bootstrap/Card";

export default function ContextComponent() {
    const textValue = useContext(TextContext);

    return (
        <Card
            border="primary"
            className="mb-2">
            <Card.Header>
                Context Component
            </Card.Header>
            <Card.Body>
                {textValue}
            </Card.Body>
        </Card>
    );
}