import IntermediateComponent from "./IntermediateComponent";
import Card from "react-bootstrap/Card";

export default function AnotherIntermediateComponent() {
    return (
        <Card 
            border="warning"
            className="mb-2 mt-2">
            <Card.Header>
                Another Intermediate Component
            </Card.Header>
            <Card.Body>
                <Card.Title>
                    <IntermediateComponent />
                </Card.Title>
            </Card.Body>
        </Card>
    );
}