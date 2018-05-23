package edu.orangecoastcollege.cs272.ic05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Predicate;

/**
 * The <code>DictionaryDemo</code> class displays all the permutations of a set of Words that can be comprised
 * to form both simple (noun verb noun) and intermediate (noun verb noun preposition noun) sentences.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class DictionaryDemo {
    public static List<Word> filter(List<Word> dictionary, Predicate<Word> predicate)
    {
        List<Word> result = new ArrayList<>();
        for(Word w: dictionary)
            if(predicate.test(w))
                result.add(w);
        return result;

    }

    public static String getSimpleSentences(List<Word> dictionary)
    {
        // simple sentence has the form: noun verb noun
        // predicate: criteria to match
        List<Word> nouns = filter(dictionary, w -> w.getCategory() == Category.NOUN);
        List<Word> verbs = filter(dictionary, w -> w.getCategory() == Category.VERB);

        StringBuilder sb = new StringBuilder("");
        // loop throught nouns


        for(Word noun1 : nouns)
            for(Word verb : verbs)
                for(Word noun2: nouns)
                {
                 sb.append(noun1.getBase()).append(" ").append(verb.getPlural()).append(" ").append(noun2.getBase()).append("\n");
                 sb.append(noun1.getBase()).append(" ").append(verb.getPlural()).append(" ").append(noun2.getPlural()).append("\n");

                 sb.append(noun1.getPlural()).append(" ").append(verb.getBase()).append(" ").append(noun2.getBase()).append("\n");
                 sb.append(noun1.getPlural()).append(" ").append(verb.getBase()).append(" ").append(noun2.getPlural()).append("\n");
                }
                   /* outPut +=  noun1.getBase()+ " " + verb.getPlural()+ " " + noun2.getBase() + ".\n";
                    outPut +=  noun1.getBase()+ " " + verb.getPlural()+ " " + noun2.getPlural() + ".\n";
                    outPut +=  noun1.getPlural()+ " " + verb.getBase()+ " " + noun2.getBase() + ".\n";
                    outPut +=  noun1.getPlural()+ " " + verb.getBase()+ " " + noun2.getPlural() + ".\n";
                } */
        return sb.toString();
    }


    public static String getIntermediateSentences(List<Word> dictionary)
    {
        List<Word> nouns = filter(dictionary, w -> w.getCategory() == Category.NOUN);
        List<Word> verbs = filter(dictionary, w -> w.getCategory() == Category.VERB);
        List<Word> preposition = filter(dictionary, w -> w.getCategory() == Category.PREPOSITION);

        StringBuilder sb = new StringBuilder("");

        for(Word noun1 : nouns)
            for(Word verb : verbs)
                for(Word noun2: nouns)
                    for(Word prep :preposition)
                        for(Word lastNoune: nouns)
                        {
                            sb.append(noun1.getBase()).append(" ").append(verb.getPlural()).append(" ").append(noun2.getBase()).append(" ").append(prep.getBase()).append(" ").append(lastNoune.getPlural()).append("\n");
                            sb.append(noun1.getBase()).append(" ").append(verb.getPlural()).append(" ").append(noun2.getBase()).append(" ").append(prep.getPlural()).append(" ").append(lastNoune.getBase()).append("\n");

                            sb.append(noun1.getPlural()).append(" ").append(verb.getBase()).append(" ").append(noun2.getBase()).append(" ").append(prep.getPlural()).append(" ").append(lastNoune.getBase()).append("\n");
                            sb.append(noun1.getPlural()).append(" ").append(verb.getBase()).append(" ").append(noun2.getBase()).append(" ").append(prep.getBase()).append(" ").append(lastNoune.getPlural()).append("\n");

                        }
        return sb.toString();
    }




	/**
	 * Main method is the entry point to the <code>DictionaryDemo</code>.
	 *
	 * @param args Command line arguments (not used in this application)
	 */
	public static void main(String[] args) {

		List<Word> dictionary = new ArrayList<>(20);

		dictionary.add(new Word("baby", "babies", Category.NOUN));
		dictionary.add(new Word("computer", "computer", Category.NOUN));
		dictionary.add(new Word("grandmother", "grandmothers", Category.NOUN));
		dictionary.add(new Word("monkey", "monkeys", Category.NOUN));
		dictionary.add(new Word("planet", "planets", Category.NOUN));
		dictionary.add(new Word("programmer", "programmers", Category.NOUN));
		dictionary.add(new Word("puppy", "puppies", Category.NOUN));


		dictionary.add(new Word("attack", "attacks", Category.VERB));
		dictionary.add(new Word("calculate", "calculates", Category.VERB));
		dictionary.add(new Word("compute", "computes", Category.VERB));
		dictionary.add(new Word("deceive", "decieves", Category.VERB));
		dictionary.add(new Word("heal", "heals", Category.VERB));
		dictionary.add(new Word("save", "saves", Category.VERB));

		dictionary.add(new Word("in", "in", Category.PREPOSITION));
		dictionary.add(new Word("behind", "behind", Category.PREPOSITION));


		System.out.println(getSimpleSentences(dictionary));
		System.out.println(getIntermediateSentences(dictionary));

		 try (PrintWriter fileWriter = new PrintWriter(new File("outputFile")))
         {
		     fileWriter.println(getIntermediateSentences(dictionary));
         }
		 catch(IOException e){

		 }
	}

}
