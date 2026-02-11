import ContextComponent from "./ContextComponent";
import Card from "react-bootstrap/Card";

export default function IntermediateComponent() {
    return (
        <Card 
            border="danger"
            className="mb-2 mt-2">
            <Card.Header>
                Intermediate Component
            </Card.Header>
            <Card.Body>
                <Card.Title>
                    <ContextComponent />
                </Card.Title>
            </Card.Body>
        </Card>
    );
}