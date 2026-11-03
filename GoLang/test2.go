package main

import (
	"fmt"
)

func main1(){
	fmt.Println(" WELCOME TO THE CALCULATOR ")
	var n1 int
	var n2 int
	fmt.Print("Enter numbers n1 n2 : ")
	fmt.Scanf("%v %v",&n1,&n2)

	fmt.Println("Addition is : ",n1+n2)
	fmt.Println("Substraction is : ",n1-n2)
	fmt.Println("Multiplication is : ",n1*n2)
	fmt.Println("Division is : ",n1/n2)
}