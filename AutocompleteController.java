package com.example.autocomplete;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/autocomplete")
public class AutocompleteController {

    private final List<String> dataSet;
    private final SuffixTree suffixTree;

    public AutocompleteController() {
        dataSet = List.of(
                "To Kill a Mockingbird", "1984", "The Great Gatsby", "The Catcher in the Rye", "Moby-Dick", "Pride and Prejudice", "War and Peace", "The Lord of the Rings", "The Hobbit", "Harry Potter and the Sorcerer's Stone", "Crime and Punishment", "The Brothers Karamazov", "Brave New World", "The Kite Runner", "The Alchemist", "One Hundred Years of Solitude", "The Picture of Dorian Gray", "The Count of Monte Cristo", "Les Misérables", "A Tale of Two Cities", "Dracula", "Frankenstein", "The Scarlet Letter", "The Adventures of Huckleberry Finn", "Jane Eyre", "Wuthering Heights", "Anna Karenina", "The Grapes of Wrath", "Of Mice and Men", "Great Expectations", "Heart of Darkness", "The Secret Garden", "Little Women", "Fahrenheit 451", "Slaughterhouse-Five", "Animal Farm", "Lord of the Flies", "The Giver", "The Handmaid's Tale", "The Road", "Life of Pi", "The Hunger Games", "Divergent", "Ender's Game", "Percy Jackson & The Olympians: The Lightning Thief", "A Wrinkle in Time", "The Chronicles of Narnia: The Lion, the Witch, and the Wardrobe", "The Shining", "Carrie", "Misery", "It", "The Stand", "The Dark Tower", "Dune", "The Hitchhiker's Guide to the Galaxy", "Good Omens", "American Gods", "The Book Thief", "Memoirs of a Geisha", "Gone with the Wind", "The Shadow of the Wind", "Shantaram", "The Night Circus", "Circe", "Song of Achilles", "Cloud Atlas", "The Time Traveler's Wife", "The Goldfinch", "The Light We Lost", "The Midnight Library", "Where the Crawdads Sing", "Big Little Lies", "Sharp Objects", "The Lovely Bones", "Room", "The Fault in Our Stars", "Looking for Alaska", "An Abundance of Katherines", "Paper Towns", "Will Grayson, Will Grayson", "The Perks of Being a Wallflower", "Eleanor & Park", "Fangirl", "Aristotle and Dante Discover the Secrets of the Universe", "We Were Liars", "Red Queen", "Throne of Glass", "A Court of Thorns and Roses", "Shadow and Bone", "Six of Crows", "Crooked Kingdom", "King of Scars", "The Cruel Prince", "The Wicked King", "The Queen of Nothing", "Children of Blood and Bone", "Legend", "Prodigy", "Champion", "Warcross", "The Maze Runner", "The Scorch Trials", "The Death Cure", "The Kill Order", "The Fever Code", "The Ballad of Songbirds and Snakes", "The Lunar Chronicles: Cinder", "Scarlet", "Cress", "Winter", "Stars Above", "Heartless", "The Selection", "The Elite", "The One", "The Heir", "The Crown", "The 5th Wave", "The Infinite Sea", "The Last Star", "Ready Player One", "Ready Player Two", "Artemis", "Project Hail Mary", "The Martian", "Dark Matter", "Recursion", "The Midnight Library", "Before We Were Strangers", "The Seven Husbands of Evelyn Hugo", "Daisy Jones & The Six", "Malibu Rising", "Carrie Soto is Back", "Verity", "It Ends With Us", "Ugly Love", "November 9", "Maybe Someday", "Hopeless", "Confess", "Reminders of Him", "All Your Perfects", "Without Merit", "Finding Cinderella", "Finding Perfect", "Slammed", "This Girl"
        );

        StringBuilder textBuilder = new StringBuilder();
        for (String title : dataSet) {
            textBuilder.append(title.toLowerCase()).append("#");
        }
        suffixTree = new SuffixTree(textBuilder.toString(), dataSet);
    }

    @GetMapping
    public List<String> getSuggestions(@RequestParam("query") String query) {
        List<String> lowercaseMatches = suffixTree.findByPrefix(query.toLowerCase());

        List<String> results = new ArrayList<>();
        for (String match : lowercaseMatches) {
            for (String original : dataSet) {
                if (original.toLowerCase().equals(match)) {
                    results.add(original);
                    break;
                }
            }
        }
        return results;
    }
}
