package api2;

public class ComputeEnginePrototype {
	
	@SuppressWarnings("unused")
	public void prototype(ComputeEngine engine) {
		// This prototype ends up being the simplest, even though the implementation of it is likely to be the most complex of the components.
		// We know the input here is going to be an int, so the parameters are nice and simple, and I've chosen to represent the output as a String -
		// that's a somewhat-opinionated result type, and it would be completely fine to have a more general wrapper. By choosing a String,
		// I'm forcing the ComputeEngine component to handle all result formatting as well as the actual computation - since these two things are going
		// to be very tightly coupled as far as the implementation (how to format a result really depends on what that result represents), this
		// is reasonable to put in one component, but keeping things more general is also fine. API Design is much more art than science!
		String result = engine.compute(null);
	}
}
//Is fine because everything's going to be in the same java process that's an o
//ption here it's not really an option for the other ones cool and yeah so that
//s This Is This is one way to do it this is obviously there are many ways to go 
//about doing this but if you were kind of wondering like hey what what should my 
//api's look like for looking at this and saying yeah there seems to be an awful lot of
