import React from "react";
import Button from "react-bootstrap/Button";
import ButtonGroup from "react-bootstrap/ButtonGroup";

import toKebabCase from "../utils/kebab";

export default function Control({ propList, updateStyle }) {
    return (
        <div>
            {propList.map(([propName, options]) => {
                return (
                    <>
                        <h5 key={`${propName}-heading`}>
                            {toKebabCase(propName)}
                        </h5>
                        <ButtonGroup key={`${propName}-btn-grp`}>
                            {options.map((propOption) => (
                                <Button 
                                    key={`${propName}-${propOption}-btn`}
                                    onClick={() => updateStyle(propName, propOption)}
                                    variant="primary"
                                >
                                    {propOption}
                                </Button>
                            ))}
                        </ButtonGroup>
                    </>
                )
            })}
        </div>
    );
}