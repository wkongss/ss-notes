## HTML

Hypertext Markup Language (HTML) provides the structure and content of webpages. When a web browser receives HTML, it is then transformed into a tree called a Document Object Model (DOM) in memory that can then be accessed and manipulated with languages such as JavaScript.

Being a Markup language, the core functionality lies within tags with structure defined within angle brackets:

```HTML
<!-- Example: Normal Tag-->
<element-name attribute1=value1 attribute2=value2>
    Content
</element-name>

<!-- Example: Self-closing Tag-->
 <element-name attribute1=value1 attribute2=value2 />
```

Not all tags are self-closing. See the reference at the end of this section for more information.
Generally, an HTML file will have the following structure:
```HTML
<!-- DOCTYPE simply tells the browser this is an HTML document -->
<!DOCTYPE html>
<!-- The html element is the root of our DOM tree. Everything is included in it -->
<html lang="en">
<!-- The head element contains all the metadata of our page. This includes linking external resources, titles, and encoding -->
<head>
    <!-- Character set encoding. UTF-8 is the standard for its variable length (very efficient for Roman characters, but also includes emojis and characters from other languages by allowing for longer length characters -->
    <meta charset="UTF-8">
    <!-- Viewport defines the dimensions of the site -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Define additional metadata using <meta name="key" content="value"> 
         This can make it easier for web crawlers for search engines to index our page (Search Engine Optimization) -->

    <!-- Title! This is what is shown in the browser tab. -->
    <title>Document</title>

    <!-- We could also link in style sheets with CSS or scripts with JS using a <link> tag to make sure resources are
     loaded in before we begin to render. -->
</head>
<body>
    Content of our page!
</body>
</html>
```

### Important Element Types:

 - `html` - defines the root of the DOM tree (the entirety of our page)

 - `head` - defines the metadata and resources used by the page
    - `<meta name="key" content="value" />` - defines metadata
    - `<link rel="type of resource" href="resource location" />` - defines a connection to an external resource (CSS, JS, Fonts)

 - `body` - defines the content of the page

**Sectioning tags**:
    - `<header> </header>` - used for the content header at the top of the page. Can include things like logo and a navbar.
        - `<nav> </nav>` - used for a navbar, usually place inside of a header
    - `<main> </main>` - the main content of the page
    - `<footer> </footer>` - used for the content footer at the bottom of the page. Can include things like copyright info and other links.
    - `<section></section>` - A section of the page
    - `<div></div>` - The most generic sectioning tag, just represent some portion of the page, usually for styling purposes.
    - `<span></span>` - Another general tag. Similar to div but used to style in-line. 

**Content tags**:

 - `<a href="resource location"> </a>` - anchor, oftentimes used for links or redirections to another page
 - `<img src="image location"/>` - image tag
 - `<video/>` - video tag
 - `<audio/>` - audio tag
 - `<embed> </embed>` - embedded content from other resources
 - `<iframe> </iframe>` - nested content (i.e. a page within a page)

**Text tags**:

 - `<h1></h1> to <h6></h6>` - Defines different levels of headings, with h1 being the largest and h6 being the smallest.
 - `<p> </p>` - The most basic type of text. Just a paragraph.
 - `<strong></strong>` - Defines important text. This is usually bolded in CSS, but is also particularly helpful for text readers for accomodation.
 - `<em></em>` - Defines emphasized text. Usually stylistically italicized, but also useful for text readers.
 - `<br/>` - Line break

**Lists**

 - `<ol> </ol>` defines an ordered list (numbered by 1, 2, 3)...
 - `<ul> </ul>` defines an unoredered list (bullet points)
 - `<li> </li>` defines an item in the list.

**Tables**

 - `<table> </table>` - Defines a table for displaying data.
 - `<thead> </thead>` - Head of the table, usually with a single `tr` with multiple `th` elements defining the table columns.
    - `<tr> </tr>` - Table row with a body of multiple table cell elements (`th`, `td`).
    - `<th> </th>` - Table cell defining a non-data element (usually descriptive names like "Time" "Money")
 - `<tbody> </tbody>` - The main content of the table, usually contains multiple `tr` with multiple `td` elements that define the table.
    - `<td> </td>` - Represents a cell containing data within the table.
 - `<tfoot> </tfoot>` - Footer of the table, can contain aggregate information, for instance.

`th` and `td` elements can take up multiple cells using the `rowspan` attributes to span multiple rows and `colspan` attributes to span multiple columns.

**Forms**

 - `<form> </form>` - Defines a form for gathering user input. Houses various elements such as:
    - `<input/>` - Overloaded by the `type` attribute. Different types change the way it interacts for user input.
        - `text` is a standard text field.
        - `email` is an email field.
        - `password` is for passwords
        - `date` is for dates.
        - `radio` is for radio buttons that limit a selection to one per group, linked together by their `name` attribute.
        - `checkbox` is for checkboxes
        - `number` if for numbers.
        - See more here: https://developer.mozilla.org/en-US/docs/Web/HTML/Reference/Elements/input
    - `<textarea> </textarea>` - Defines a block of text area to gather user input.
    - `<button />` - A clickable button!
    - `<select> </select>` - A selection box that allows the user to select from one of many options.
        - `<option> </option>` - Defines an option that can be selected.

### Inline vs. Block Elements

Elements have a default rendering mode:
 - Inline elements continue on the same line when rendering.
 - Block elements take up their own line when rendering determined by their bounding box.
 - Inline-block elements continue on the same line, but also have their own bounding box that can be adjusted similar to a block element.

This can be changed by changing the `display` property of the element via CSS.

Lastly, some elements are considered "Semantic" - this means that tag itself gives meaning to the content of the tag itself. For example, `img` defines an image, and `article` defines a written newsletter. On the other hand, a `div` and `span` can wrap around just about anything.

Reference: https://developer.mozilla.org/en-US/docs/Web/HTML/Reference/Elements

## CSS

Cascading Style Sheets (CSS) are how we add flourishes and style into the backbone of our sheet. There are three main ways we can add style to to our HTML:

1. **External**: Declare an external CSS file that houses our styles and link it via a `<link/>` tag within our document `head`. This is the preferred way of going about things.
2. **Internal**: Include a `<style> </style>` tag with our CSS as the content.
3. **Inline**: To style specific elements, use the `style` attribute of the element and include the styling there like `<tag style="font-size: 20px; padding: 1rem>` (not recommended).

These are generally in order of best practice from best to worst. Generally use the first option if you can.

### Selectors and Properties

CSS works by selecting elements from our HTML and assigning them properties. This generally works by way of the following syntax:

```CSS
    selector {
        property: value;
    }
```

This will assign the value to the property for all elements matching the selector.

#### Selectors

 - `*` - selects every element
 - `tag` - selects all elements that have the tag specified
 - `.class` - selects all elements with a class attribute containing the class specified.
 - `#id` - selects all elements with the id attribute specified.
 - `tag[attr=value]` - selects all elements that have the tag and attribute equal to the value specified.
 - `tag:pseudoclass` - selects a portion of the element's behavior (i.e. hover effects) to more finely target how the element changes based on state.

These basic selectors can all be combined with each other. If multiple selections share the same properties, you can use a selector list to combine them all into one selection:

```CSS
selector1, selector2, selector3 {
    Shared Properties
}
```

Combinators allow you to use multiple selectors in order to get more specific selections:

 - `selector1 selector2 { ... }` is the descendant combinator. It will select all `selector2` elements that are nested within a `selector1` element.
 - `selector1 > selector2` is the child combinator. It will select all `selector2` elements that are direct children of a `selector1` element.

Reference: https://www.w3schools.com/css/css_selectors.asp, https://developer.mozilla.org/en-US/docs/Web/CSS/Guides/Selectors/Selectors_and_combinators
 
#### Box Model

 - The total footprint of an element is defined by the margin, border, padding, and content.
    - The innermost layer is the content - the size of the element itself. Can be changed with width and height properties.
    - Wrapping that is the padding - this defines the distance between the content and the border.
    - The border is then the outer bounding box of the element.
    - Lastly, margin is the minimum space between the border and other elements.
    - Note that these properties are not inherited from children to parents.


#### Flexbox

Flexbox is a display property that allows for the automatic arrangement and alignment of elements within a parent element. This is incredibly useful for when you want to evenly space elements out, for example.

 - To start, select a container element and provide it with the property of `display: flex;`. All children within the parent should now conform to the flexbox parameters set in the parent.
    - A flexbox aligns the elements based on a main axis and a cross-axis orthogonal to it. By default, the main axis is horizontal and goes from left to right and the cross-axis spans from top to bottom. Change the main axis with the `flex-direction` property (`row` for left to right, `row-reverse` for right to left, `column` for top to bottom, `column-reverse` for bottom to top).
    - Use the `justify-content` property to align the elements along the main axis (`flex-start` for start, `center` for center, `flex-end` for end, `space-around`, `space-evenly`, `space-between` for even spacing).
    - use the `align-items` property to align the elements along the cross-axis (`)

#### Animations

Create animations