token=bcff1b3971022bb825a49f668a516e3ff491a883

1.

	e) Sim o projeto passou o quality gate.
		(imagem 1 em anexo)
		
		
	f)
	
	Bug: Save and reuse "Random()", creating a new Random() everytime a random value is needeed is ineficient.
	How to solve: Create a instance of Random() static in the class and reuse it everytime we need to.
	
	Vulnerabilities: None, this project has no vulnerabilities.
	
	Security hotspot: When software generates predictable values in a context requiring unpredictability, it may be possible for an attacker to guess the next value that will be generated, and use this guess to impersonate another user or access sensitive information.
	How to solve: Use a cryptographically strong random number generator (RNG) like "java.security.SecureRandom" in place of this PRNG. 
	
	
	code smell: Shared coding conventions allow teams to collaborate efficiently. This rule checks that all constant names match a provided regular expression
	How to solve: Rename a constant name to match a regular expression.
	
	

2.

	a) Debt found is 2h:09min, this means the time that a person would take in average, to solve every issue in that project.
	
