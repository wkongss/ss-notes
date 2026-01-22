### Bootstrap

Bootstrap is a library that contains a ton of default CSS stylings and JS snippets that you can apply to your elements automatically by assigning them the specified class.

Bootstrap can either be packaged with your application or delivered to the frontend client via a content delivery network (CDN) such as [jsdelivr](https://getbootstrap.com/docs/5.3/getting-started/introduction/#cdn-links).

Some general things to keep in mind: 
- When dealing with column width, the full screen is around `12`. So if you wanted something to span `1/2` of the screen horizontally, use `6`.

Everything that bootstrap has is a default baseline! This means that if you're importing from a CDN, you can override the customizations for your specific needs. To do so, assign either inline style (not recommended) or use an ID for the element.
 - This is because styles have priority of: inline > id > class > general.

If you're packaging bootstrap with your application, instead use [Sass](https://getbootstrap.com/docs/5.3/customize/sass/) to extend what you need to extend.

See a cheatsheet here: https://getbootstrap.com/docs/5.3/examples/cheatsheet/

Examples here: 
https://getbootstrap.com/docs/5.3/examples/

Documentation here:
https://getbootstrap.com/docs/5.3/getting-started/introduction/