You can buy 4 different items - A, B, C or D. 
You should provide path /checkout/itemFirstName=itemFirstUnit.
You can buy 1, 2, 3 or 4 items in one time. 
If you want to buy 4 items in one time path should be /checkout/itemFirstName=itemFirstUnit/itemSecondName=itemSecondUnit/itemThirdName=itemThirdUnit/itemFourthName=itemFourthUnit.
If you put wrong item(s) name(s), bill will be calculate only for correct(s). You receive information that calculations are only for correct(s) as well.
If path is wrong, you receive error page. 
If path is correct, but item(s) is(are) wrong, you receive information that you provided wrong item(s).
If you add the same items 2 or more times, output will have lines for each of them. 