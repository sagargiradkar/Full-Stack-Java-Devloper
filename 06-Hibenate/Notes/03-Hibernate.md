@Dynamicupdate(value=true)
==========================
It is used to generate the update query only for the fields on which the setter injection performed.

Entity object fields are
    sid,sname,sage,saddress

The entity object setter method used is main method is
    student.setSaddress("RCB")

The query generated is
update
        Student 
    set
        saddress=? 
    where
        sid=?

Note :within the transaction , persistance object would be synchonised to row in the database.
