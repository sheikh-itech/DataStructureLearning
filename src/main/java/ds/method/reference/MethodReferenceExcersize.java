package ds.method.reference;

public class MethodReferenceExcersize {

	public static void main(String[] args) {
	
		Common activity = null;
		
		activity = Student::whoIAm;
		activity.activity();
		activity = Student::whatIAmLearning;
		activity.activity();
		activity = Student::whatIsNext;
		activity.activity();
		System.out.println();
		
		
		activity = Person::whoIAm;
		activity.activity();
		activity = Person::whatIAmDoing;
		activity.activity();
		activity = Person::whatIsNext;
		activity.activity();
		System.out.println();
		
		
		activity = Employee::whoIAm;
		activity.activity();
		activity = Employee::whatIAmDoing;
		activity.activity();
		activity = Employee::whatIsNext;
		activity.activity();
	}
}
