### Flexbox

Flexbox is a way of automatically aligning elements within a container. To begin, create a container element with property `display: flex`.

```html
<div class="container">
    <div class="flex-item">1</div>
    <div class="flex-item">2</div>
    <div class="flex-item">3</div>
    <div class="flex-item">4</div>
</div>
```

```css
.container {
    display: flex;
}
```

The way items are rendered is based off of two axes: the main-axis (left to right by default) and the cross-axis (top to bottom by default).

Change the main-axis with the `flex-direction` property of the container:
 - `row` for left to right,
 - `row-reverse` for right to left,
 - `column` for top to bottom,
 - `column-reverse` for bottom to top.

The cross-axis is automatically reassigned either left to right or bottom to top to stay orthogonal to the main axis.

```CSS
.container {
    display: flex;
    flex-direction: column;
}
```

Align items along the main-axis with the `justify-content` property:

 - `flex-start` for the beginning of the axis,
 - `center` for the center,
 - `flex-end` for the end of the axis,
 - `space-between` for the first item at the start, last item at the end, and then even space in between.
 - `space-around` for the space in between each element and the border to be the same (as in each element has the same margin along the main axis).
 - `space-evenly` makes sure the space between the border and all elements remains constant.

Align items along the cross-axis with the `align-items` property:

 - `flex-start` for the beginning of the axis,
 - `center` for the center,
 - `flex-end` for the end of the axis,
 - `stretch` to stretch children along the axis.

If elements are too large to fit in a single row, use the `flex-wrap` property to wrap them into multiple rows:

 - `nowrap` is the default and prevents wrapping.
 - `wrap` allows for wrapping.