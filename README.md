# qortal-blackjack
Insperation from catbref’s Lottery and ciyam.at . Blackjack game for Qortal.

Java class called blackjack that implements a function buildQortalAT to create an instance of a smart contract. The contract implements a blackjack game with the specified game duration (in minutes) and maximum number of players. The buildQortalAT function takes these two inputs, performs validity checks and returns the contract data as a byte array.
 includes the creation of the AT, which is initiated by calling the buildQortalAT method, passing in the game duration and maximum number of players as arguments. The created AT will include several fields, such as game duration, max players, number of players, current player, current sum, max sum, winner, last transaction timestamp, transaction type, and so on. The AT will also define two transaction types: "Hit" and "Stand". Finally, the main method calls the buildQortalAT method and does some additional processing with the returned creation bytes.