//Problem1: Find last element of a list
var list1: List[Int] = List(1,2,3,4,5,6,7,7,81)
def lastOfListInt(list:List[Int]):Int={
	var revList = list.reverse
	return (revList.head)
}
println("Problem1: "+lastOfListInt(list1))

//Problem2: Find Penultimate element of a list
var list2:List[Int] = List(1,3,5,7,9)
def penultimateOfListInt(list:List[Int]):Int={
	var revList = list.reverse
	var tailRevList = revList.tail
	return (tailRevList.head)
}
println("Problem2: "+penultimateOfListInt(list2))

//Problem3: Find Kth element of a list
var list3:List[Int] = List(1,14,22,7,83)
def kthOfListInt(kth:Int,list:List[Int]):Int={
	var index = kth-1
	return(list(index))
}
println("Problem3: "+kthOfListInt(3,list3))

//Problem4: Find number of elements in a list
var list4:List[Int] = List(1,2,3,4,5,6,7,8,151,66,11)
def listLengthInt(list:List[Int]):Int={
	return(list.length)
}
println("Problem4: "+listLengthInt(list4))

//problem5: Reverse a list
var list5:List[Int] = List(44,55,66)
def reverseListInt(list:List[Int]):List[Int]={
	return(list.reverse)
}
println("Problem5: "+reverseListInt(list5))
//Problem 6:Is list a palindrome?
var list6:List[Int] = List(1,2,3,2,1)
def palindromeListInt(list:List[Int]):Boolean={
	var revList = list.reverse
	for (k <- 0 to list.length-1){
		if (revList(k) != list(k)){
			return (false)
		}
	}
	return (true)
}
println("Problem6: "+palindromeListInt(list4))

//Problem7: 'Flatten' a nested list -> concatenate them all together
var list7:List[List[Int]] = List(List(1,1,1),List(2,2,2),List(3,3,3))
def flattenListInt(list:List[List[Int]]):List[Int]={
	var newList:List[Int] =  List()
	for (k <- 0 to list.length-1){
		newList = List.concat(newList,list(k))
	}
	return (newList)
}
println("Problem7: "+ flattenListInt(list7))

//Problem8: Delete duplicates of list
var list8:List[String] = List("a","a","b","b","b","b","c","c","d","d","a","a")
def deleteDuplicatesList(list:List[String]):List[String]={
	var newList:List[String] = List()
	var dup = list(0)
	for (k <- 1 to list.length-1){
		if (list(k) != dup){
			newList ::= dup
			dup = list(k) 
		}
	}
	newList ::= dup
	newList = newList.reverse
	return (newList)
}
println("Problem8: "+ deleteDuplicatesList(list8))

//Problem9:Put consecutive duplicates of list elements into sublists
var list9:List[String] = List("a","a","b","b","x","d","d","b","b")
def sublistDuplicatesList(list:List[String]):List[List[String]]={
	var newMultiList:List[List[String]] = List()
	var newList:List[String] = List()
	var dup = list(0)
	var times = 0
	for (k <- 1 to list.length-1){
		times += 1
		if (list(k) != dup){ //|| k == list.length-1 (returns 1 too few)
			for (m <- 0 to times-1){
				newList ::= dup
			}
			times = 0
			newMultiList ::= newList
			newList = List()
			dup = list(k)
		}
	}
	for(m <- 0 to times){
		newList ::= dup
	}
	newMultiList ::= newList
	newMultiList = newMultiList.reverse
	return (newMultiList)
}	
println("Problem9: "+sublistDuplicatesList(list9))

//Problem10: Run-Length encoding of list -> (#of elements, Element)
var list10:List[String] = List("a","a","b","b","b","x","d","d","b","b")
def runLengthEncodingList(list:List[String]):List[List[String]]={
	var newMultiList:List[List[String]] = List()
	var newList:List[String] = List()
	var dup = list(0)
	var times = 0
	for (k <- 1 to list.length-1){
		times += 1
		if (list(k) != dup){ //|| k == list.length-1 (returns 1 too few)
			for (m <- 0 to times-1){
				newList ::= dup
			}
			times = 0
			newMultiList ::= newList
			newList = List()
			dup = list(k)
		}
	}
	for(m <- 0 to times){
		newList ::= dup
	}
	newMultiList ::= newList
	//Run Length encoding bit
	var encodedNewMultiList: List[List[String]] = List()
	var encodedNewList:List[String] = List()
	for (k <- 0 to newMultiList.length-1){
		encodedNewList ::= (newMultiList(k).length).toString()
		encodedNewList ::= newMultiList(k)(0)
		encodedNewMultiList ::= encodedNewList
		encodedNewList = List()
	}
	return (encodedNewMultiList)
}
println("Problem10: "+runLengthEncodingList(list10))

//Problem11: Only elements with duplicates are put into 'tuples'
var list11:List[String] = List("a","a","b","b","x","d","d","d","d","b","b")
def modifiedRunLengthEncodingList(list:List[String]):List[List[String]]={
	var newMultiList:List[List[String]] = List()
	var newList:List[String] = List()
	var dup = list(0)
	var times = 0
	for (k <- 1 to list.length-1){
		times += 1
		if (list(k) != dup){ //|| k == list.length-1 (returns 1 too few)
			for (m <- 0 to times-1){
				newList ::= dup
			}
			times = 0
			newMultiList ::= newList
			newList = List()
			dup = list(k)
		}
	}
	for(m <- 0 to times){
		newList ::= dup
	}
	newMultiList ::= newList
	//Run Length encoding bit
	var encodedNewMultiList: List[List[String]] = List()
	var encodedNewList:List[String] = List()
	for (k <- 0 to newMultiList.length-1){
		if(newMultiList(k).length > 1){
			encodedNewList ::= (newMultiList(k).length).toString()
		}
		encodedNewList ::= newMultiList(k)(0)
		encodedNewMultiList ::= encodedNewList
		encodedNewList = List()
	}
	return (encodedNewMultiList)
}
println("Problem11: "+modifiedRunLengthEncodingList(list11))

//Problem12: Decode run-length list:
def decodeList(list:List[List[String]]):List[String]={
	var newList:List[String] = List()
	for (k <- 0 to list.length-1){
		var eLength = 1
		var element = list(k)(0)
		if (list(k).length == 2){
			eLength = list(k)(1).toInt
		}
		for (m <- 0 to eLength-1){
			newList ::= element
		}
	}
	newList = newList.reverse
	return (newList)
}
println("Problem12: "+decodeList(modifiedRunLengthEncodingList(list11)))

//Problem13: Run-length encoding of list (direct solution) => ALREADY DONE, LOOK UP
//Problem14: Duplicate elements of a list
var list14:List[String] = List("a","b","c","d","d","c")
def duplicateList(list:List[String]):List[String]={
	var newList:List[String] = List()
	for (k <- 0 to list.length-1){
		for (m <- 0 to 1){
			newList ::= list(k)
		}
	}
	newList = newList.reverse
	return (newList)
}
println("Problem14: "+duplicateList(list14))

//Problem15: duplicate elements of a list a certain number of times
var list15:List[String] = List("a","x","b","c","c","d","d","b")
def duplicateAmountList(amount:Int,list:List[String]):List[String]={
	var newList:List[String] = List()
	for (k <- 0 to list.length-1){
		for (m <- 0 to amount-1){
			newList ::= list(k)
		}
	}
	newList = newList.reverse
	return (newList)
}
println("Problem15: "+duplicateAmountList(3,list15))

//Problem16: Drop every Nth element from a list
var list16:List[Int] = List(1,2,3,4,5,6,7,8,9)
def dropNthFromList(nth:Int,list:List[Int]):List[Int]={
	var newList:List[Int] = List()
	for (k <- 0 to list.length-1){
		if (list(k)%nth != 0){//not a multiple of nth
			newList ::= list(k)
		}
	}
	newList = newList.reverse
	return(newList)
}
println("Problem16: "+dropNthFromList(3,list16))

//Problem17: Split list into 2 parts
var list17:List[String] = List("a","b","b","a","l","o","v","e")
def splitList(nth:Int,list:List[String]):List[List[String]]={
	var newList:List[String] = List()
	var lLength = 0
	var newMultiList:List[List[String]] = List()
	for (k <- 0 to list.length-1){
		if (k == nth){
			newList = newList.reverse
			newMultiList ::= newList
			newList = List()
		}
		newList ::= list(k)
	}
	newList = newList.reverse
	newMultiList ::= newList
	newMultiList = newMultiList.reverse
	return(newMultiList)
}
println("Problem17: "+splitList(4,list17))

//Problem18: Extract slice (part) of a list (start,end) gives (startindex....endindex-1)
var list18:List[String] = List("n","e","v","e","r","g","o","n","n","a","g","i","v","e")
def listSlice(start:Int,end:Int,list:List[String]):List[String]={
	var newList:List[String] = List()
	for (k <- start-1 to end-1){
		newList ::= list(k)
	}
	newList = newList.reverse
	return (newList)
}
println("Problem18: "+listSlice(6,10,list18))

//Problem19: Rotate List N places to the Left (so move head to tail)
var list19:List[String] = List("H","e","a","d","o","r","t","a","i","l","s")
def rotateListLeft(places:Int,list:List[String]):List[String]={
	var newList:List[String] = List()
	for (k <- places to list.length-1){
		newList ::= list(k)
	}
	for (k <- 0 to places-1){
		newList ::= list(k)
	}
	newList = newList.reverse
	return (newList)
}
println("Problem19: "+rotateListLeft(4,list19))

//Problem20: remove Kth element from a list and put it in a tuple
var list20:List[String] = List("I","A","M","G","o","o","d")
def removeElementIntoTuple(kth:Int,list:List[String]):Tuple2[List[String],String]={
	var newList:List[String] = List()
	for (k <- 0 to list.length-1){
		if (k != kth-1){
			newList ::= list(k)
		}
		//else{
		//	var leftOut = list(k)
		//}
	}
	var leftOut = list(kth-1)
	newList = newList.reverse
	var Tuple= Tuple2(newList,leftOut)
	return(Tuple)
}
println("Problem20: "+removeElementIntoTuple(4,list20))

//Problem21: Insert element at given position into list
var list21:List[String] = List("o","h","m","g","o","d")
def insertElementIntoList(added:String,kth:Int,list:List[String]):List[String]={
	var newList:List[String] = List()
	for (k <- 0 to list.length-1){
		if (k == kth-1){
			newList ::= added

		}
			newList ::= list(k)
	}
	newList = newList.reverse
	return(newList)
}
println("Problem21: "+insertElementIntoList("y",4,list21))

//Problem22: Create list of Int within a range
def createIntList(start:Int,end:Int):List[Int]={
	var newList:List[Int] = List()
	for(k <- start to end){
		newList ::= k
	}
	newList = newList.reverse
	return(newList)
}
println("Problem22: "+createIntList(4,9))

//Problem23: Extract number of randomly selected elements from a list
var randInt = scala.util.Random
var list23:List[String] = List("a","b","c","d","e","f","g","h")
def randomElementsFromList(number:Int,list:List[String]):List[String]={
	var newList:List[String] = List()
	var correct = true
	var gotIt = 0
	var chosen = list(randInt.nextInt(list.length-1))
	for (k <- 0 to number-1){
		while(correct){
			chosen = list(randInt.nextInt(list.length-1))
			if (newList.length == 0){
				newList ::= chosen
			}
			for (m <- 0 to newList.length-1){
				if (chosen == newList(m)){
					gotIt = 1 //already in newList
				}
			}
			if (gotIt == 0){
				correct = false
			}
			gotIt = 0
		}
		newList ::= chosen
		correct = true
	}
	newList = newList.reverse
	return (newList)
}
println("Problem23: "+randomElementsFromList(3,list23))

//Problem24: Draw N different random numbers from 1 to M
//var randInt = scala.util.Random
def randomLotteryOfNumbers(number:Int,range:Int):List[Int]={
	var newList:List[Int] = List()
	var chosen = randInt.nextInt(range)+1 //so from 1 to range
	var correct = true
	var gotIt = 0
	newList ::= chosen
	for (k <- 0 to number-1){
		while(correct){
			chosen = randInt.nextInt(range)+1
			for (m <- 0 to newList.length-1){
				if (chosen == newList(m)){
					gotIt = 1
				}
			}
			if (gotIt == 0){
				correct = false
			}
			gotIt = 0
		}
		newList ::= chosen
		correct = true
	}
	newList = newList.reverse
	return (newList)
}
println("Problem24: "+randomLotteryOfNumbers(6,49))

//Problem25: Generate random permutation of elements of a list
//var randInt = scala.util.Random
var list25:List[String] = List("a","b","c","d","e","f")
def randomizeOrderList(list:List[String]):List[String]={
	var newList:List[String] = List()
	var shortenedList:List[String] = List()
	var shorterList:List[String]=List()
	var chosen = randInt.nextInt(list.length)
	var correct = true
	var gotIt = 0 
	for (k<- 0 to list.length-1){
		shortenedList ::= list(k) //copies the list to shortenedList
		shorterList ::= list(k) //copies list to shorterList
	}
	for (k <- 0 to list.length-1){
		chosen = randInt.nextInt(shorterList.length) //choose random element
		newList ::= shorterList(chosen)
		shorterList = List()
		for (k <- 0 to shortenedList.length-1){
			if (shortenedList(k) != shortenedList(chosen)){
				shorterList ::= shortenedList(k) //essentially removes the chosen from the list
			}
		}
		shortenedList = List()
		for (k <-0 to shorterList.length-1){
			shortenedList ::= shorterList(k)
		}
		shortenedList = shortenedList.reverse
	}
	newList = newList.reverse
	return(newList)
}
println("Problem25: "+randomizeOrderList(list25))

//Problem26: Generate combinations of K distinct objects chosen from N elements of a list -> how many ways can something be combined
var list26:List[String] = List("a","b","c","d","e")
def combinationsOfList(size:Int,list:List[String]):List[List[List[String]]]={
	var newList:List[String] = List()
	var addOnList:List[String] = List()
	var newMultiList:List[List[List[String]]] = List()
	var chosen = randInt.nextInt(list.length) //Chooses a random element from the list
	var head:String = ""
	var tail:List[String] = List()
	var combinationList:List[String] = List()
	var listOfLists:List[List[String]] = List()
	for (k <- 0 to list.length-1){
		for (m <- k to list.length-1){//
			newList ::= list(m) //rest of list first
		}

		for (m <- 0 to k-1){
			newList ::= list(m) //then what used to be the heads (so basically each element becomes the 1st iteratively)
		}
		
		newList = newList.reverse
		//create a lists of lists
		listOfLists ::= newList
		newList = List() //empty the newList
	}
	for (k<- 0 to listOfLists.length-1){
		newMultiList ::= headAndTail(size,listOfLists(k))
	}
	return (newMultiList)
}
def headAndTail(size:Int,list:List[String]):List[List[String]]={
	var newList:List[String] = List()
	var combinationList:List[String] = List()
	var combinateTailsList:List[String] = List()
	var newMultiList:List[List[String]] = List()

	var head1 = list.head
	var tail1 = list.tail
	for (k <- 0 to list.length-1){
		newList ::= list(k)
	}
	newList = newList.reverse
	for (k <- 1 to size-1){//so size 4 loops 3 times (leaves last element to be changed)
		head1 = newList.head
		tail1 = newList.tail
		newList = List() //empty the list
		for (m <- 0 to tail1.length-1){
			newList ::= tail1(m) //newList becomes tail
		}
		newList = newList.reverse
		combinationList ::= head1 //add 1 element at a time until reaches needed size
	}
	for (k <- 0 to tail1.length-1){//Final tail length  (so in this case if size is 4, should be 2 ("d","e"))
		//change last element
		for (m <- 0 to combinationList.length-1){ //All permutations of final element
			combinateTailsList ::= combinationList(m) //copies list
		}
		combinateTailsList ::= tail1(k) //adds on the last element
		newMultiList ::= combinateTailsList //adds it to the main list
		combinateTailsList = List() //empties it

	}
	return (newMultiList)
}
println("Problem26: "+combinationsOfList(3,list26)) //Good Enough -> Just flatten it after

//Problem27: Group elements into set of disjoint subsets ->
//Part A) how many ways can a group of 9 work in 3 disjoint subgroups of 2,3,4
var list27:List[String] = List("Zach","Chris","Josh","Mac","Leo","Bilal","Will","Phil","Sam")
def listOf(size:Int,list:List[String]):List[List[String]]={//ListOf2/3/4 => List(List(people),List(remaining))
	//Choose 2 random
	var newList:List[String] = List()
	var newMultiList:List[List[String]]=List()
	var shortenedList:List[String] = List()
	var shorterList:List[String]=List()
	var chosen = randInt.nextInt(list.length)
	var person = list(chosen)
	for (k<- 0 to list.length-1){
		shortenedList ::= list(k) //copies the list to shortenedList
		shorterList ::= list(k) //copies list to shorterList
	}
	for (k <- 0 to size-1){//So list of size(2 for testing case)
		chosen = randInt.nextInt(shorterList.length) //choose random element
		newList ::= shorterList(chosen)
		shorterList = List()
		for (k <- 0 to shortenedList.length-1){
			if (shortenedList(k) != shortenedList(chosen)){
				shorterList ::= shortenedList(k) //essentially removes the chosen from the list
			}
		}
		shortenedList = List()
		for (k <-0 to shorterList.length-1){
			shortenedList ::= shorterList(k)
		}
		shortenedList = shortenedList.reverse
	}
	newList = newList.reverse
	newMultiList ::= newList
	newMultiList ::= shortenedList
	newMultiList = newMultiList.reverse//so head is chosen people list
	return(newMultiList)
	//chosen = randInt.nextInt(list.length) 
}
def groupDisjointSubsets(list:List[String],size1:Int,size2:Int,size3:Int):List[List[String]]={
	var newMultiList:List[List[String]] = List()
	var useItList:List[String] = List()
	var newList:List[String] = List()
	var listed:List[List[String]] = List()
	var sizeList:List[Int] = List(size1,size2,size3)
	for  (k <- 0 to list.length-1){
		newList ::= list(k) //copy of list
	}
	//
	for (k <- 0 to sizeList.length-1){
		listed = listOf(sizeList(k),newList)
		newMultiList ::= listed(0)
		newList = List() //empty is out
		for (m <- 0 to listed(1).length-1){
			newList ::= listed(1)(m) //fill newList with remainders
		}
	}
		

	//newList ::= listed(1)
	//
	//newList = listOf(size2,useItList(1))
	//useItList = List()
	//newMultiList ::= newList(0)
	//
	//useItList = listOf(size3,newList(1))
	//newMultiList ::= useItList(0)

	return (newMultiList)
}
println("Problem27: "+groupDisjointSubsets(list27,5,2,2))

//Problem28: Sort list of lists accrding to length of sublists -> shrtest lists come first
var list28:List[List[String]] = List(List("a","b","c"),List("d","e"),List("f","g","h","i"),List("J"),List("k","l"))
def sortListofLists(list:List[List[String]]):List[List[String]]={
	//get max list size
	var maxListLength = list(0).length
	var listLength = 0
	for(k <-1 to list.length-1){ //Gets longest list
		listLength = list(k).length
		if (listLength > maxListLength){
			maxListLength = listLength
		}
	}

	var newMultiList:List[List[String]] = List()
	for (k <- 0 to maxListLength){//Sorts lists, going from smallest to largest)
		for (m <- 0 to list.length-1){
			if (list(m).length == k){ //starts with length 1, to max
				newMultiList ::= list(m)
			}
		}
	}
	newMultiList = newMultiList.reverse
	return (newMultiList)
}
println("Problem28: "+sortListofLists(list28))



//ARITHMETIC
println("\n")
//Problem31: Determine whether integer is a prime
def isPrime(number:Int):Boolean={
	if ( number == 1 || number == 2 || number == 3 || number == 5 || number == 7){
		return (true)
	}
	if (number%2 == 0 || number%3 == 0 || number%5 == 0 || number%7 == 0){
		return (false)
	}
	else{
		return (true)
	}
}
println("Problem31: "+isPrime(999))

//Problem32: Determine greatest common divisor between 2 Ints
def greatestCommonDivisor(number1:Int,number2:Int):Int={
	var smallestNumber = number1
	if (number1 > number2){
		smallestNumber = number2
	}
	var divisor = smallestNumber
	while (divisor > 0){
		if (number1%divisor == 0 && number2%divisor == 0){
			return (divisor)
		}
		divisor -= 1
	}
	return (divisor)
}
println("Problem32: "+greatestCommonDivisor(315,3))

//Problem33:  Determine whether 2 Ints are Coprime (GCD = 1)
def isCoprime(number1:Int,number2:Int):Boolean={
	if (greatestCommonDivisor(number1,number2)==1){
		return (true)
	}
	return (false)
}
println("Problem33: "+isCoprime(612,1213))

//Problem34: Calculate Euler's totient function phi(m) => number of Ints that are coprime to m
def eulerTotient(number:Int):Int={
	var count = 0
	var coPrime = false
	for (k <- 1 to number){
		coPrime = isCoprime(k,number)
		if (coPrime){
			count += 1
		}
	}
	return (count)
}
println("Problem34: "+eulerTotient(15))

//Problem35: Determine prime factors of given Int
def primeFactorsOfInt(number:Int):List[Int]={
	var primeGCD = 1
	var primeList:List[Int] = List()
	var changedNumber = number
	var gcd = 0
	while(primeGCD < number && changedNumber != 1){
		gcd = greatestCommonDivisor(changedNumber,primeGCD)
		if (isPrime(primeGCD) && gcd != 1){//so the divided is a prime and not 1
			while (changedNumber%primeGCD == 0){
				primeList ::= primeGCD
				changedNumber = changedNumber/primeGCD
			}
			
		}
		primeGCD += 1
	}

	primeList = primeList.reverse
	return (primeList)
}


//Problem36: Determine prime factors of given int and list their multiplicity
def primeFactorsOfIntMultiplicity(list:List[Int]):List[List[Int]]={
	var newMultiList:List[List[Int]] = List()
	var newList:List[Int] = List()
	var alreadyDoneList:List[Int] = List()
	var number = 0
	var count = 0
	var gotIt = 0
	for (k <- 0 to list.length-1){
		number = list(k)
		for (m <- 0 to alreadyDoneList.length-1){
			if (number == alreadyDoneList(m)){
				gotIt = 1
			}
		}
		if (gotIt == 0){//So not already done
			for (p <- 0 to list.length-1){
				if (number == list(p)){
					count +=1
				}
			}
			alreadyDoneList ::= number
			newList ::= count
			newList ::= number
			newMultiList ::= newList
			newList = List()
		}
		count = 0
		gotIt = 0
	}
	newMultiList = newMultiList.reverse
	return (newMultiList)
}
println("Problem36: "+primeFactorsOfIntMultiplicity(primeFactorsOfInt(315)))

//Problem37  && 38: No idea

//Problem39: List of prime numbers
def primeList(start:Int,end:Int):List[Int]={
	var newList:List[Int] = List()
	for (k <- start to end){
		if (isPrime(k)){
			newList ::= k
		}
	}
	newList = newList.reverse
	return(newList)
}
println("Problem39: "+primeList(7,31))

//Problem40: Goldbach's conjencture => every +ve Int > 2 is sum of 2 primes
def goldbachConjencture(number:Int):List[Int]={
	//for (i <- 0 to primeList(0,number)){
	//	primesList ::= primeList(0,number)(0)
	//}
	var primesList:List[Int] = primeList(0,number) //creates list of primes
	var newList:List[Int] = List()
	var num1 = 0
	var num2 = 0
	for (k <- 0 to primesList.length-1){
		num1 = primesList(k)
		for (m <- 0 to primesList.length-1){
			num2 =primesList(m)
			if (num1+num2 == number){
				newList ::= num1
				newList ::= num2
				return (newList)
			}

		}
	}
	return (newList)
}
println("Problem40: "+goldbachConjencture(28))

//Problem41: List of golbachConjenctures => given range of Ints, print list of all even numbers and their Goldbach composition
def goldbachConjenctureList(start:Int,end:Int){
	var primesList:List[Int] = primeList(0,end)
	var num1 = 0
	var num2 = 0
	var chosenNumber = start
	println("Problem41: ")
	for (i <- start to end){
		chosenNumber = i
		if (chosenNumber%2 ==0){//Even
			for (k <- 0 to primesList.length-1){
				num1 = primesList(k)
				for (m <- 0 to primesList.length-1){
					num2 = primesList(m)
					if (num1+num2 == chosenNumber){
						println(chosenNumber+" = "+num1+"+"+num2)
					}
				}
			}
		}
	}
}
goldbachConjenctureList(9,20)


//LOGIC AND CODES
//Problem 46: Truth tables for logical expressions => and, or, nand, nor ,xor, imp, equivalence(logical)
class LogicalOperations{

	def and(bool1:Boolean,bool2:Boolean):Boolean={
		if (bool1 && bool2){
			return (true)
		}
		return (false)
	}

	def or(bool1:Boolean,bool2:Boolean):Boolean={
		if (bool1 || bool2){
			return (true)
		}
		return (false)
	}

	def nand(bool1:Boolean,bool2:Boolean):Boolean={
		if (bool1 && bool2){
			return (false)
		}
		return (true)
	}

	def nor(bool1:Boolean,bool2:Boolean):Boolean={
		if (bool1 || bool2){
			return (false)
		}
		return (true)
	}

	def xor(bool1:Boolean,bool2:Boolean):Boolean={
		if (bool1 && !bool2 || !bool1 && bool2){//only 1 is true
			return (true)
		}
		return (false)
	}

	def imply(bool1:Boolean,bool2:Boolean):Boolean={
		if(!bool1 && bool2){
			return (false)
		}
		return (true)
	}

	def equivalence(bool1:Boolean,bool2:Boolean):Boolean={
		if(bool1 == bool2){
			return (true)
		}
		return (false)
	}

	var truthList:List[Boolean] = List(true,false)

	def truthTable(function:(Boolean,Boolean) => Boolean){
		println("A          B     Result")
		var bool1 = true
		var bool2 = false
		for (k<- 0 to truthList.length-1){
			bool1 = truthList(k)
			for (m<-0 to truthList.length-1){
				bool2 = truthList(m)
				var result = function(bool1,bool2)
				println(s"$bool1    $bool2    $result")
			}
		}
	}
}
var LogicStuff = new LogicalOperations
LogicStuff.truthTable(LogicStuff.and)

//Problem49: Gray code => List of numbers in binary code (00,01,11,10), (000,001,011,010) -> 000 index 2, 001 index2, 011 index 2, 010 index 1, 110 index 1, 111 index 0, 
																								//every time before you move up an index, change previous index 0 <-> 1, change next index to 1 
																								//after moving change all previous indexes to 0 iteratively
def grayCode(size:Int):List[String]={
	var newList:List[String] = List()
	var binaryString:Array[String] = Array.ofDim[String](size)
	for (i <- 0 to size-1){
		binaryString(i) = "0"
	}
	var end = true
	var index = size-1
	//First 2 instances "000","001"
	newList ::= arraytoString(binaryString)
	//binaryString(binaryString.length-1) = "1"
	//newList ::= arraytoString(binaryString)
	//other instances
	while (end){
		//before move
		//change previous index
		if (index == size-1){//happens only once
			binaryString(index) match{
			case "0" => binaryString(index) = "1"
			case "1" => binaryString(index) = "0"
			}
			newList ::= arraytoString(binaryString)
			index -=1
		}
		else{
			//change next index
			binaryString(index) = "1" 
			println(arraytoString(binaryString))
			newList ::= arraytoString(binaryString)
			
			println("Index:"+index)
			if (index == 0){
				for (i <- index+1 to size-1){
					binaryString(i) = "1"
				}
				newList ::= arraytoString(binaryString)
			}
			for (k <- index+1 to size-1){
				binaryString(k) = "0"
				println("hi "+arraytoString(binaryString))
				newList ::= arraytoString(binaryString)
			}

			if (index == 0){
				end = false
			}
			if (index > 0){
				index -= 1
			}
		}	
	}
	newList = newList.reverse
	return (newList)
}

def arraytoString(array:Array[String]):String={
	var actualString = ""
	for (k <- 0 to array.length-1){
		actualString += array(k)
	}
	return (actualString)
}
println("Problem49: "+grayCode(4)) //Doesn't Work bagh!