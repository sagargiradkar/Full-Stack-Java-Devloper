<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books Form</title>
</head>
<body>
    <h1>Books Form</h1>
    <form action="saveBook" method="post">
        <table>
            <tr>
                <td><label>Book Name:</label></td>
                <td><input type="text" name="bName" value="${book.bName}" required /></td>
            </tr>
            <tr>
                <td><label>Author Name:</label></td>
                <td><input type="text" name="authorName" value="${book.authorName}" required /></td>
            </tr>
            <tr>
                <td><label>Book Price:</label></td>
                <td><input type="text" name="bPrice" value="${book.bPrice}" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Submit</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
