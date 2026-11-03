package main

import (
	"fmt"
	"slices"
)

func Program1(){
	var name string
	var age int
	var cgpa float32
	var collegeName string

	fmt.Println("Enter Name : ")
	fmt.Scanf("%s",&name)
	fmt.Println("Enter Age : ")
	fmt.Scanf("%v",&age)
	fmt.Println("Enter CGPA : ")
	fmt.Scanf("%v",&cgpa)
	fmt.Println("Enter College Name : ")
	fmt.Scanf("%s",&collegeName)
	fmt.Printf("Name of the student is : %s , Age is : %v, CGPA is : %f , College name is : %s",name,age,cgpa,collegeName)
}


func AreaCircle(radius float64) float64{
	const PI=3.14
	return PI*radius*radius
}

func EvenOdd(num int) bool{
	if num%2==0{
		return true
	}
	return false
}

func Factorial(){
	var n int
	fmt.Println("Enter the number : ")
	fmt.Scanf("%d",&n)

	fact:=1
	for i:=1;i<=n;i++ {
		fact=fact*i
	}
	fmt.Print(fact)
}

func Prime(num int){
	var ct int
	
	for i:=2;i<num;i++{
		if num%i==0{
			ct++
		}
	}
	if ct==0{
		fmt.Print("Prime")
	}else{
		fmt.Print("Composite")
	}
}


func Fibbonacci(num int){
	a:=0
	b:=1
	c:=0

	fmt.Print(a," ",b," ")
	
	for i:=3;i<=num;i++{
		c=a+b
		fmt.Print(c," ")
		a=b
		b=c
	}
}


func FizzBuzz(){
	for i:=1;i<=100;i++{
		if i%3==0 && i%5==0{
			fmt.Println(i,"FIZZBUZZ")
		}else if i%3==0{
			fmt.Println(i,"FIZZ")
		}else if i%5==0{
			fmt.Println(i,"BUZZ")
		}
	}
}


func ArraySum(arr []int) ([]float32){

	if len(arr)==0{
		return []float32{0,0}
	}
	var sum float32
	for _,val:= range(arr){
		sum=sum+float32(val)
	}

	ans:=make([]float32,2)
	ans[0]=sum
	ans[1]=sum/float32(len(arr))
	return ans
}


func MaxMin(slice []int) (int,int){
	if len(slice)==0{
		return 0,0
	}
	return slices.Min(slice),slices.Max(slice) //in-build function for min max function.
}

//reverse slice without using slice function.
func ReverseSlice(slice []int) []int{
	ans:=make([]int,5)
	ct:=0
	for i:=len(slice)-1;i>=0;i-- {
		ans[ct]=slice[i]
		ct+=1
	}
	return ans
}


//Frequency Counter.
func counter(slice []int) map[int]int{
	//Given a slice of integers, use a map to count the frequency of each number.
	dict:=make(map[int]int)
	for _,val:=range(slice){
		ct,ok:=dict[val]
		if !ok{
			dict[val]=1
			continue
		}
		dict[val]=ct+1
	}
	return dict
}

//Two sum
func TwoSum(slice []int,target int) (int,int){
	if len(slice)==0{
		return -1,-1
	}
	

	left:=0
	right:=len(slice)-1

	slices.Sort(slice)

	for(left<right){
		if(slice[left]+slice[right]==target){
			return left,right
		}else if(slice[left]+slice[right]>target){
			right-=1
		}else{
			left+=1
		}
	}
	fmt.Println("Not Found!!")
	return -1,-1
}

func StudentManagement(){
	record:=make(map[string]int)

	for{
		fmt.Println("1. Insert")
		fmt.Println("2. Update")
		fmt.Println("3. Delete")
		fmt.Println("4. Search")
		fmt.Println("Enter choice : ")
		
		var choice int
		fmt.Scanf("%v",&choice)

		switch choice{
		case 1:
			//insert
			var name string
			var marks int
			fmt.Println("Enter Name & Marks : ")
			fmt.Scanf("%s %v",&name,&marks)

			_,ok:=record[name]
			if ok{
				fmt.Println("Student Already exists")
				continue
			}

			record[name]=marks
			fmt.Println("Data Added!")
			
		case 2:
			// Update Data
			fmt.Println("Enter the student name : ")
			var name string
			fmt.Scanf("%s",&name)

			_,ok:=record[name]

			if !ok{
				fmt.Println("Data not found!!")
				continue
			}

			var marks int
			fmt.Println("Enter the new marks : ")
			fmt.Scanf("%v",&marks)
			record[name]=marks

			fmt.Println("Student Data Added!!")
		case 3:
			fmt.Println("Enter the name to be deleted : ")
			var name string
			fmt.Scanf("%s",&name)

			_,ok:=record[name]
			
			if !ok{
				fmt.Println("Data not found! ")
				continue
			}
			delete(record,name)
			fmt.Println("Data deleted.")

		case 4:
			//search student
			var name string
			fmt.Println(" Enter the name : ")
			fmt.Scanf("%s",&name)

			_,ok:=record[name]
			if !ok{
				fmt.Println("Name is not present")
				continue
			}

			fmt.Println(name," has marks : ",record[name])
		}
	}
}

type Emp struct{
	Id string
	Name string
	Salary int
	Dept string
}


//struct 
func EmployeeManagement(){
	slice:=make([]Emp,0)
	var n int
	fmt.Println("Enter the input range : ")
	fmt.Scanf("%v",&n)
	for i:=0;i<n;i++{
		var emp Emp
		fmt.Println("Enter the details : ")
		fmt.Scanf("%s %s %v %s",&emp.Id,&emp.Name,&emp.Salary,&emp.Dept)

		slice=append(slice, emp)
	}


	//print there details.
	for _,val:=range(slice){
		fmt.Println(val)
	}
}

//struct 

type StudentStruct struct{
	name string
	roll int
	marks int
}


func Operation(data []StudentStruct) (float32,string){
	sum:=0
	var name string
	prevMarks:=-1
	for _,obj:=range data{
		sum+=obj.marks
		if prevMarks<obj.marks{
			prevMarks=obj.marks
			name=obj.name
		}
	}
	return float32(sum)/float32(len(data)),name
}

func Student(){
	slice:=make([]StudentStruct,0)
	var n int
	fmt.Println("Enter the input range : ")
	fmt.Scanf("%v",&n)
	for i:=0;i<n;i++{
		var stu StudentStruct
		fmt.Println("Enter the details : ")
		fmt.Scan(&stu.name,&stu.roll,&stu.marks)
		slice=append(slice, stu)
	}

	fmt.Println(Operation(slice))
}

func main(){
	Student()

}