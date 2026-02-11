import { Prism as SyntaxHighlighter } from 'react-syntax-highlighter';
import { vscDarkPlus } from 'react-syntax-highlighter/dist/esm/styles/prism';

export default function JSXDisplay({ codeString }) {
  return (
    <SyntaxHighlighter key="syntax" language="jsx" style={vscDarkPlus} className="mb-2">
      {codeString}
    </SyntaxHighlighter>
  );
};