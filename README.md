# TheZuulGame

<h2>Description</h2>
A lab where I refactor a project for improvement and add extra features
<h2>Skills learnt</h2>

<ul>
<li>Designing Classes.</li>
<li>Responsibility-driven design.</li>
<li>Coupling</li>
<li>Cohesion.</li>
<li>Refactoring.</li>  
</ul>


<h2>Languages and Utilities Used</h2>

- <b>Java</b> 
- <b>Eclipse</b>

<h2>Environments Used </h2>

- <b>Windows 10</b> (21H2)

<h1>General description</h1>
Start with either the version of the project we analysed in the lecture and used as a starting
point in the demo, or with the version completed in the demo (do you want a player to have
‘health’ and be able to eat items? Make sure that a player has sufficient health to be able to
encounter your items). If you have another extension idea than the one described in the
following, please feel free to implement that instead, provided that it is of similar (or greater)
complexity: check with the module tutors before you start if you are unsure.
The suggested Game of Zuul enhancement consists in adding items to some of the rooms
in the game. Each item has a one word name and appears in a room with a probability of
60%. When entering a room with an item in it the room description should indicate the item
is there.
The user is required to type in get to attempt to take an item, and then the name of the item
they wish to take. For example the user might type get printer if they wished to take the
printer.
If the item name given in the command does not exist in the room the user is notified that
the item is not in the room.
If the item name given in the command does exist in the room the item is added to an
inventory that keeps track of everything the user is carrying, and is removed from that room.
<h2>Specifications</h2>
** 1. (Adding items) **
<p>&nbsp;</p>
You will first need an Item class to model items. The start-up project is designed to handle
two word commands, therefore we must give our items a one word name. Accordingly,
there should be a field in the class, of type String, properly initialised in the constructor.
The Item class should also have an accessor method, to allow the retrieval of the item
name. Since the name given to an Item via the constructor should not be changed, we will
not provide a mutator method.
We will deploy items in some of the rooms. Therefore, an item is something that belongs to
a room, just like the exits do. What modifications (new fields, methods, etc.) should we
make in the Room class to reflect that?
<p>&nbsp;</p>
** 2. (An Inventory) **
<p>&nbsp;</p>
We will now add a component to allow the player to carry items they have taken. Inside the
Player class we should add an aggregate data structure to hold all the items we have
taken.
  
  
  
<!--
 ```diff
- text in red
+ text in green
! text in orange
# text in gray
@@ text in purple (and bold)@@
```
--!>
