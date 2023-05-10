<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  </head>
  <body>
    <h1>customer</h1></br>
    <form method="post" action="/serverweb/post.do">
      <table>
        <tr>
          <td>user ID</td>
          <td><input type="text" name="userId" size="10"/></td>
        </tr>
        <tr>
          <td>name </td>
          <td><input type="text" name="userName" size="10"/></td>
        </tr>
        <tr>
          <td>password </td>
          <td><input type="password" name="passwd" size="10"/></td>
        </tr>
        <tr>
          <td>gender</td>
          <td><input type="radio" name="gender" value="male"/>male
              <input type="radio" name="gender" value="female"/>female</td>
        </tr>
        <tr>
          <td>JOB</td>
          <td><select name="job">
                <option value="salary"/>Salary
                <option value="houseKeeper" selected />HouseKeeper
                <option value="student"/>Student
                <option value="other"/>Other
              </select></td>
        </tr>
        <tr>
          <td>Favorites</td>
          <td><input type="checkbox" name="item" value="ìì¬"/>ìì¬
              <input type="checkbox" name="item" value="ê²½ì "/>ê²½ì 
              <input type="checkbox" name="item" value="ì ì¹"/>ì ì¹
              <input type="checkbox" name="item" value="ì°ì"/>ì°ì
              <input type="checkbox" name="item" value="ì¤í¬ì¸ "/>ì¤í¬ì¸ 
              <input type="checkbox" name="item" value="ê´ê³ "/>ê´ê³ </td>
        </tr>
      </table><p/>
      <input type="submit" value="ìë ¥ìë£"/>
      <input type="reset" value="ì¬ìë ¥"/>
    </form>
  </body>
</html>