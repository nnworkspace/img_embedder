# Code Generator for Embedding Clickable Image URLs in Markdown or HTML Format 

This tool is to batch convert image URLs that stored in a plain text file to Markdown (Github style) code or HTML code. The generated image links are clickable.

The image hosting service assumed here is [imgur.com](imgur). The image in the direct link will show a "large thumbnail" whose width is 640 pixel. The image link after click will be the image of original size.  

## Usage Example

```
gradle genCode -Pmyargs=exported_image_urls,md
```

## Sample Input
Content of the file `test_urls`:
```
http://i.imgur.com/d7ykDaZ.jpg
http://i.imgur.com/WVPjuB2.jpg
http://i.imgur.com/wIAjnUL.jpg
``` 