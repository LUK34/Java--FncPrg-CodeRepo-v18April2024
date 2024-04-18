package kw.kng;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Courses
{
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getCategory() 
	{
		return category;
	}
	public void setCategory(String category) 
	{
		this.category = category;
	}
	public int getReviewScore() 
	{
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) 
	{
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() 
	{
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) 
	{
		this.noOfStudents = noOfStudents;
	}
	
	public String toString()
	{
		return name + ":" + noOfStudents + ":" +reviewScore;
	}
	public Courses(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

}


public class FP11Functional_CustomClass 
{
	public static void main(String[] args)
	{
		List<Courses> coursero=List.of(
					new Courses("Spring", "Framework" , 98 , 20000 ),
					new Courses("Spring Boot", "Framework" , 95 , 18000 ),
					new Courses("API", "Microservices" , 97 , 22000 ),
					new Courses("Microservices", "Microservices" , 91 , 14000 ),
					new Courses("FullStack", "FullStack" , 91 , 14000 ),
					new Courses("AWS", "Cloud" , 92 , 21000 ),
					new Courses("Azure", "Cloud" , 99 , 21000 ),
					new Courses("Docker", "Cloud" , 92 , 20000 ),
					new Courses("Kubernetes", "Cloud" , 91 , 20000 ),
					new Courses("Core Java", "Programming Language" , 91 , 12000 ),
					new Courses("Adv Java", "Programming Language" , 91 , 12000 ),
					new Courses("Python", "Programming Language" , 84 , 10000 )
				);
		
		System.out.println("allMatch -> Are all the courses greater than 90");
		System.out.println(coursero.stream()
													   .allMatch(course -> course.getReviewScore()>90));
		System.out.println("allMatch -> Are all the courses greater than 95");
		System.out.println(coursero.stream()
													   .allMatch(course -> course.getReviewScore()>95));
		
		Predicate<Courses>  reviewScoreGreaterThan95Predicate = course -> course.getReviewScore()>95;
		Predicate<Courses>  reviewScoreGreaterThan90Predicate = course -> course.getReviewScore()>90;
		Predicate<Courses>  reviewScoreLessThan95Predicate = course -> course.getReviewScore()<95;
		Predicate<Courses>  reviewScoreLessThan90Predicate = course -> course.getReviewScore()<90;
		Predicate<Courses>  reviewScoreLessThan80Predicate = course -> course.getReviewScore()<80;
		Predicate<Courses>  reviewScoreLessThan70Predicate = course -> course.getReviewScore()<70;
		
		System.out.println("allMatch -> Are all the courses greater than 90 using Predicate:");
		System.out.println(  coursero.stream()
														.allMatch(reviewScoreGreaterThan90Predicate)  );
		System.out.println("allMatch -> Are all the courses greater than 95 using Predicate:");
		System.out.println(  coursero.stream()
														.allMatch(reviewScoreGreaterThan95Predicate)  );
		System.out.println("noneMatch -> Are all the courses less than 95 using Predicate:");
		System.out.println(  coursero.stream()
														.noneMatch(reviewScoreLessThan90Predicate)  );
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		Comparator<Courses> comparingCourses_onBasisOfStudent_ASC_ORDER = Comparator.comparing(Courses::getNoOfStudents);
		Comparator<Courses> comparingCourses_onBasisOfStudent_DESC_ORDER = Comparator.comparing(Courses::getNoOfStudents).reversed();
		
		Comparator<Courses> comparingCourses_onBasisOfStudent_onBasisOfReviewScore_ASC_ORDER = Comparator.comparing(Courses::getNoOfStudents)
																																																 .thenComparing(Courses::getReviewScore);             
		
		Comparator<Courses> comparingCourses_onBasisOfStudent_onBasisOfReviewScore_DESC_ORDER = Comparator.comparing(Courses::getNoOfStudents)
																																																	.thenComparing(Courses::getReviewScore)
																																																	.reversed();
		
		
		
		System.out.println("Comparing (number of students for a course)  and (number of reviews) in ASC ORDER: ");
		System.out.println(coursero.stream()
														.sorted(comparingCourses_onBasisOfStudent_onBasisOfReviewScore_ASC_ORDER)
														.collect(Collectors.toList() ) );
		
		System.out.println("Comparing (number of students for a course)  and (number of reviews)in DESC ORDER: ");
		System.out.println(coursero.stream()
														.sorted(comparingCourses_onBasisOfStudent_onBasisOfReviewScore_DESC_ORDER)
														.collect(Collectors.toList() ) );
		
		System.out.println("Comparing (number of students for a course)  and (number of reviews) in ASC ORDER LIMIT Record COUNT by 5: ");
		System.out.println(coursero.stream()
														.sorted(comparingCourses_onBasisOfStudent_onBasisOfReviewScore_ASC_ORDER)
														.limit(5) //LIMIT upto first 5 records
														.collect(Collectors.toList() ) );
		
		
		System.out.println("Comparing (number of students for a course)  and (number of reviews)in DESC ORDER LIMIT Record COUNT by 5:  ");
		System.out.println(coursero.stream()
														.sorted(comparingCourses_onBasisOfStudent_onBasisOfReviewScore_DESC_ORDER)
														.limit(5) //LIMIT upto 5 records
														.collect(Collectors.toList() ) );
		
		System.out.println("Comparing (number of students for a course)  and (number of reviews) in ASC ORDER SKIP Record COUNT by 3: ");
		System.out.println(coursero.stream()
														.sorted(comparingCourses_onBasisOfStudent_onBasisOfReviewScore_ASC_ORDER)
														.skip(3) //SKIP upto first 3 records
														.collect(Collectors.toList() ) );
	    
		System.out.println("Comparing (number of students for a course)  and (number of reviews)in DESC ORDER SKIP Record COUNT by 3:  ");
		System.out.println(coursero.stream()
														.sorted(comparingCourses_onBasisOfStudent_onBasisOfReviewScore_DESC_ORDER)
														.skip(3) //SKIP upto 3 records
														.collect(Collectors.toList() ) );
		
		System.out.println("Comparing (number of students for a course)  and (number of reviews) in ASC ORDER SKIP Record COUNT by 3 LIMIT COUNT by 5: ");
		System.out.println(coursero.stream()
														.sorted(comparingCourses_onBasisOfStudent_onBasisOfReviewScore_ASC_ORDER)
														.skip(3) //SKIP upto first 3 records
														.limit(5)
														.collect(Collectors.toList() ) );
				
		
		System.out.println(" Collect review score greater than 90 using takeWhile(): ");
		System.out.println(coursero.stream()
														.takeWhile(course -> course.getReviewScore()>90)
														.collect(Collectors.toList() ) );
		
		System.out.println(" Collect review score greater than 90 using dropWhile(): ");
		System.out.println(coursero.stream()
														.dropWhile(course -> course.getReviewScore()>90)
														.collect(Collectors.toList() ) );
		
		System.out.println("Finding the MAX  VALUE of student and review : ");
		System.out.println(coursero.stream()
														.max(comparingCourses_onBasisOfStudent_onBasisOfReviewScore_ASC_ORDER).get() );			
		
		System.out.println("Finding the MIN  VALUE of student and review : ");
		System.out.println(coursero.stream()
														.min(comparingCourses_onBasisOfStudent_onBasisOfReviewScore_ASC_ORDER).get() );	
		
		System.out.println("Filter the Review Score less than 90 and take the MIN VALUE : ");
		System.out.println(coursero.stream()
														.filter(reviewScoreLessThan90Predicate)
														.min( comparingCourses_onBasisOfStudent_onBasisOfReviewScore_ASC_ORDER).get() );
		
		System.out.println("Filter the Review Score less than 70. If there is no value take the GIVEN VALUE : ");
		System.out.println(coursero.stream()
										            .filter(reviewScoreLessThan70Predicate)
										            .min(comparingCourses_onBasisOfStudent_onBasisOfReviewScore_ASC_ORDER)
										            .orElse(new Courses("C", "Programming", 68, 10000))
										);		
		System.out.println("Filter the Review Score less than 95. findFirst() Method: ");
		System.out.println(coursero.stream()
	            										.filter(reviewScoreLessThan95Predicate)
	            										.findFirst());		
		
		
		System.out.println("Filter the Review Score less than 95. findAny() Method: ");
		System.out.println(coursero.stream()
	            										.filter(reviewScoreLessThan95Predicate)
	            										.findAny());		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Filter the Review Score Greater than 95 and get the number of students:  ");
		System.out.println(coursero.stream()
	            										.filter(reviewScoreGreaterThan95Predicate)
	            										.collect(Collectors.toList() )
	            						);	
		
		System.out.println("Filter the Review Score Greater than 95 and get the number of students of that course -> Get the TOTAL SUM of it: ");
		System.out.println(coursero.stream()
	            										.filter(reviewScoreGreaterThan95Predicate)
	            										.mapToInt(Courses::getNoOfStudents) 
	            										.sum());
		
		System.out.println("Filter the Review Score Greater than 95 and get the number of students of that course -> Get the TOTAL AVG of it: ");
		System.out.println(coursero.stream()
	            										.filter(reviewScoreGreaterThan95Predicate)
	            										.mapToInt(Courses::getNoOfStudents) 
	            										.average());
		
		System.out.println("Filter the Review Score Greater than 95 and get the number of students of that course -> Get the TOTAL AVG of it->VALUE: ");
									     coursero.stream()
	            										.filter(reviewScoreGreaterThan95Predicate)
	            										.mapToInt(Courses::getNoOfStudents) 
	            										.average()
	            										.ifPresentOrElse(
	            									            average -> System.out.printf("%.2f%n", average),
	            									            () -> System.out.println("No data available")
	            									        );
		
		
		System.out.println("Filter the Review Score Greater than 95 and get the number of students of that course -> Get the COUNT of it: ");
		System.out.println(coursero.stream()
	            										.filter(reviewScoreGreaterThan95Predicate)
	            										.mapToInt(Courses::getNoOfStudents) 
	            										.count());
		
		System.out.println("Filter the Review Score Greater than 95 and get the number of students of that course -> Get the MAX of it: ");
		System.out.println(coursero.stream()
	            										.filter(reviewScoreGreaterThan95Predicate)
	            										.mapToInt(Courses::getNoOfStudents) 
	            										.max());
		
		
		System.out.println("Filter the Review Score Greater than 95 and get the number of students of that course -> Get the MAX of it->VALUE: : ");
											coursero.stream()
	            										.filter(reviewScoreGreaterThan95Predicate)
	            										.mapToInt(Courses::getNoOfStudents) 
	            										.max()
	            										.ifPresentOrElse(
	            												max -> System.out.printf("%d%n", max),
	            									            () -> System.out.println("No data available")
	            									        );
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Grouping the data on the basis of CATEGORY: ");
		System.out.println(	coursero.stream()
															.collect(Collectors.groupingBy(Courses::getCategory))		
										);
		
		System.out.println("Grouping the data on the basis of CATEGORY and get the COUNT: ");
		System.out.println(	coursero.stream()
															.collect(Collectors.groupingBy(Courses::getCategory  , Collectors.counting() ) )		
										);
		
		System.out.println("Grouping the data on the basis of CATEGORY and get the COUNT: ");
		System.out.println(	coursero.stream()
															.collect(Collectors.groupingBy(Courses::getCategory  , 
																		 Collectors.maxBy(Comparator.comparing(Courses::getReviewScore)) )
																	     )		
										);
		System.out.println("Grouping the data on the basis of CATEGORY and get the COURSE NAME: ");
		System.out.println(coursero.stream()
															.collect(Collectors.groupingBy(Courses::getCategory  , 
																		 Collectors.mapping(Courses::getName, Collectors.toList()))
																		)		
										);
		
		
		
		
		
		
		
		
		
	}

}
