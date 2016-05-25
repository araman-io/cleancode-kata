We now have a repeatable pattern to solve for larger numbers as well. However there are 2 things which are bugging me here 
* there is a special if clause in for tensspeller which means that the orderamount knowns about an internal secret. This is a smell and should go
* when we switched to the spellers model; I believed that the code for spellers was easy and didnt need tests. I was mistaken. I should have been adding tests for the spellers too

