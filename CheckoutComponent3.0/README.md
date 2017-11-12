You can buy items for out shop. 
You should update Items.txt file if you need to add new items. Default, we have four items - A, B, C and D, which were provided. 
You should scan items by using POST request. You should request below path: /CheckoutComponent/main/checkout/post.
You have to use request in below format: [{"name":"yourname1","unit":"yourunit1"},{"name":"yourname2","unit":"yourunit2"}] i.e. [{"name":"B","unit":2}].
If you provide item which isn't in our shop, program will calculate bill for correct. 
If provided unit is wrong (isn't positive or isn't integral), you will receive bill only for items with positive and integral units. 