import React from "react";
import { Prism as SyntaxHighlighter } from 'react-syntax-highlighter';
import { vscDarkPlus } from 'react-syntax-highlighter/dist/esm/styles/prism';

export default function CSSDisplay({ codeString }) {
  return (
    <SyntaxHighlighter key="syntax" language="css" style={vscDarkPlus} showLineNumbers>
      {codeString}
    </SyntaxHighlighter>
  );
};