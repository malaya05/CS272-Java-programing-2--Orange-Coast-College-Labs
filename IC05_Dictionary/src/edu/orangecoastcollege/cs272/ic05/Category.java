package edu.orangecoastcollege.cs272.ic05;

public enum Category
{
  // List of constant values
    NOUN, VERB, ADJECTIVE, ADVERB, PRONOUN, PREPOSITION, CONJUNCTION,
    INTERJECTION, DETERMINER;

    public String toString()
    {
        return   name().charAt(0) + name().substring(1).toLowerCase();
    }
}
