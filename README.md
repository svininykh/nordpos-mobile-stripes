# [NORD POS](http://www.nordpos.com) mobile servlet #
Copyright (c) 2012 Nord Trading Ltd. Apache License, Version 2.0 ([ALv2](http://www.apache.org/licenses/LICENSE-2.0.html))

This is servlet for [create, read, update and delete](http://en.wikipedia.org/wiki/Create,_read,_update_and_delete) database tables of [Openbravo Java Client POS](http://wiki.openbravo.com/wiki/Projects:POS/FAQ/javapos). Also, this servlet compatible with many other Openbravo POS forks([NORD POS](http://www.nordpos.com/), [OpenPOS](http://forge.openbravo.com/projects/Openpos), [uniCenta oPOS](http://sourceforge.net/projects/unicentaopos/) and etc.)

[![githalytics.com alpha](https://cruel-carlota.pagodabox.com/2e98c4f8151adb2c32da940a6c12fb2a "githalytics.com")](http://githalytics.com/svininykh/nordpos-mobile-stripes)

## Introduction ##
This project is an example of the ease develop and convenience of use mini servlets to access the data of big desktop application. I am propose for you to [make forks](https://github.com/svininykh/nordpos-mobile-stripes/fork) of this project, but not only for Openbravo POS developers, also for Stripes, Persist and jQuery Mobile frameworks beginers.

## Java web application powered by [Stripes Framework](http://www.stripesframework.org) ##
I am choose a Stripes, because it have simple structure of web-page and visual substitution methods of Java.

###Example JavaServer Pages###
```jsp
                <stripes:form beanclass="com.nordpos.mobile.stripes.action.LoginActionBean">
                    <table>
                        <tr>
                            <td>Name</td>
                            <td><stripes:text name="loginName"/></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><stripes:password name="loginPassword"/></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <stripes:submit name="login" value="Login" />
                            </td>
                        </tr>
                    </table>
                </stripes:form>
```

###Example Java Action###

```java
public class LoginActionBean extends BaseActionBean {

    private People loginUser = new People();
    private PeoplePersist peopleDao;
    private String loginName = "";
    private String loginPassword = "";

    @DefaultHandler
    public Resolution load() {
        return new ForwardResolution("/WEB-INF/jsp/login.jsp");
    }

    public Resolution login() {
        peopleDao = new PeoplePersist(getContext().getServletContext());
        loginUser = peopleDao.findUser(loginName, loginPassword);
        if (loginUser != null) {
            return new ForwardResolution("/WEB-INF/jsp/users.jsp");
        } else {
            return new RedirectResolution("/WEB-INF/jsp/login.jsp");
        }
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public List<People> getUsers() {
        peopleDao = new PeoplePersist(getContext().getServletContext());
        return peopleDao.findUsers();
    }
}
```

## Java data access object powered by [Persist ORM/DAO](http://github.com/rufiao/persist) ##
I am choose Persist, because you can easy get data from model of database and need minimum settings for run SQL commands.

![NORD POS mobile - Product view](http://farm9.staticflickr.com/8525/8648561310_a95651b7ba_m.jpg "Product view")

###Example Java Data Access Object###

```java
    public People findUser(String login, String password) {
        People validUser;
        if (password == null) {
            validUser = persist.read(People.class,
                    "SELECT ID, NAME, APPPASWORD FROM PEOPLE "
                    + "WHERE NAME = ? AND APPPASSWORD IS NULL",
                    login);
        } else {
            validUser = persist.read(People.class,
                    "SELECT ID, NAME, APPPASWORD FROM PEOPLE "
                    + "WHERE NAME = ? AND APPPASSWORD = ?",
                    login,
                    PasswordUtils.hashString(password));
        }

        return validUser;
    }

    public People findUser(String id) {
        return persist.read(People.class,
                "SELECT ID, NAME, APPPASWORD FROM PEOPLE WHERE ID = ?",
                id);
    }

    public List<People> findUsers() {
        return persist.readList(People.class,
                "SELECT ID, NAME, APPPASWORD FROM PEOPLE ORDER BY NAME");
    }

    public Integer countUsers() {
        return persist.read(Integer.class,
                "SELECT COUNT(ID) FROM PEOPLE");
    }
```

###Example Java Model###

```java
public class People {

    private String id;
    private String name;
    private String apppasword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppPassword() {
        return apppasword;
    }

    public void setAppPassword(String apppasword) {
        this.apppasword = apppasword;
    }
}
```

## Mobile user interface powered by [jQuery Mobile](http://www.jquerymobile.com) ##
I am choose jQuery Mobile, because you need only one line of source code for change all elements of interface.

![NORD POS mobile - Categories list](http://farm9.staticflickr.com/8254/8648529750_7b0a8d13e8_m.jpg "Categories list")
