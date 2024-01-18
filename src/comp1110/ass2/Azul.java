package comp1110.ass2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Azul {
    /**
     * Given a shared state string, determine if it is well-formed.
     * Note: you don't need to consider validity for this task.
     * A sharedState is well-formed if it satisfies the following conditions.
     * <p>
     * [turn][factories][centre][bag][discard]
     * where [turn][factories], [centre], [bag] and [discard] are replaced by the
     * corresponding small string as described below.
     * <p>
     * 0. [turn] The Turn substring is one character 'A'-'D' representing a
     * player, which indicates that it is this player's turn to make the next
     * drafting move. (In a two-player game, the turn substring can only take
     * the values 'A' or 'B').
     * <p>
     * 1. [factories] The factories substring begins with an 'F'
     * and is followed by a collection of *up to* 5 5-character factory strings
     * representing each factory.
     * Each factory string is defined in the following way:
     * 1st character is a sequential digit '0' to '4' - representing the
     * factory number.
     * 2nd - 5th characters are 'a' to 'e', alphabetically - representing
     * the tiles.
     * A factory may have between 0 and 4 tiles. If a factory has 0 tiles,
     * it does not appear in the factories string.
     * Factory strings are ordered by factory number.
     * For example: given the string "F1aabc2abbb4ddee": Factory 1 has tiles
     * 'aabc', Factory 2 has tiles 'abbb', Factory 4 has tiles 'ddee', and
     * Factories 0 and 4 are empty.
     * <p>
     * 2. [centre] The centre substring starts with a 'C'
     * This is followed by *up to* 15 characters.
     * Each character is 'a' to 'e', alphabetically - representing a tile
     * in the centre.
     * The centre string is sorted alphabetically.
     * For example: "Caaabcdde" The Centre contains three 'a' tiles, one 'b'
     * tile, one 'c' tile, two 'd' tile and one 'e' tile.
     * <p>
     * 3. [bag] The bag substring starts with a 'B'
     * and is followed by 5 2-character substrings
     * 1st substring represents the number of 'a' tiles, from 0 - 20.
     * 2nd substring represents the number of 'b' tiles, from 0 - 20.
     * 3rd substring represents the number of 'c' tiles, from 0 - 20.
     * 4th substring represents the number of 'd' tiles, from 0 - 20.
     * 5th substring represents the number of 'e' tiles, from 0 - 20.
     * <p>
     * For example: "B0005201020" The bag contains zero 'a' tiles, five 'b'
     * tiles, twenty 'c' tiles, ten 'd' tiles and twenty 'e' tiles.
     * 4. [discard] The discard substring starts with a 'D'
     * and is followed by 5 2-character substrings defined the same as the
     * bag substring.
     * For example: "D0005201020" The bag contains zero 'a' tiles, five 'b'
     * tiles, twenty 'c' tiles, ten 'd' tiles, and twenty 'e' tiles.
     *
     * @param sharedState the shared state - factories, bag and discard.
     * @return true if sharedState is well-formed, otherwise return false
     * TASK 2
     */

    /**
     * @Author: Xuanchen Wang
     */

    public static boolean isSharedStateWellFormed(String sharedState) {
        // FIXME Task 2
        String reg = "[A-D]F([0-4][a-e]{4}){0,5}C[a-f]*B([0-2][0-9]){5}D([0-2][0-9]){5}$";
        if (sharedState.matches(reg)) {
            Pattern p = Pattern.compile("F(([0-4][a-e]{4}){0,5})C([a-f]*)");
            Matcher m = p.matcher(sharedState);
            while (m.find()) {
                String m1 = m.group(1);      //the factory part
                for (int i = 0; i < m1.length(); i += 5) {
                    //if the tile in every factory is not 4, return false
                    if (m1.charAt(i) > 96) {
                        return false;
                    }
                    for (int j = 1; j < 4; j++) {
                        //if the tile is not in alphabetical order, return false
                        if (m1.charAt(i + j) > m1.charAt(i + j + 1)) {
                            return false;
                        }
                    }

                }
                String m3 = m.group(3);     //the centre part
                //if the centre is not empty
                if (!m3.equals("")) {
                    for (int i = 0; i < m.end(3) - m.start(3) - 1; i++) {
                        //if the tile is not in alphabetical order, return false
                        if (m3.charAt(i) > m3.charAt(i + 1)) {
                            return false;
                        }
                    }

                }

            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Given a playerState, determine if it is well-formed.
     * Note: you don't have to consider validity for this task.
     * A playerState is composed of individual playerStrings.
     * A playerState is well-formed if it satisfies the following conditions.
     * <p>
     * A playerString follows this pattern: [player][score][mosaic][storage][floor]
     * where [player], [score], [mosaic], [storage] and [floor] are replaced by
     * a corresponding substring as described below.
     * Each playerString is sorted by Player i.e. Player A appears before Player B.
     * <p>
     * 1. [player] The player substring is one character 'A' to 'D' -
     * representing the Player
     * <p>
     * 2. [score] The score substring is one or more digits between '0' and '9' -
     * representing the score
     * <p>
     * 3. [mosaic] The Mosaic substring begins with a 'M'
     * Which is followed by *up to* 25 3-character strings.
     * Each 3-character string is defined as follows:
     * 1st character is 'a' to 'e' - representing the tile colour.
     * 2nd character is '0' to '4' - representing the row.
     * 3rd character is '0' to '4' - representing the column.
     * The Mosaic substring is ordered first by row, then by column.
     * That is, "a01" comes before "a10".
     * <p>
     * 4. [storage] The Storage substring begins with an 'S'
     * and is followed by *up to* 5 3-character strings.
     * Each 3-character string is defined as follows:
     * 1st character is '0' to '4' - representing the row - each row number must only appear once.
     * 2nd character is 'a' to 'e' - representing the tile colour.
     * 3rd character is '0' to '5' - representing the number of tiles stored in that row.
     * Each 3-character string is ordered by row number.
     * <p>
     * 5. [floor] The Floor substring begins with an 'F'
     * and is followed by *up to* 7 characters in alphabetical order.
     * Each character is 'a' to 'f' - where 'f' represents the first player token.
     * There is only one first player token.
     * <p>
     * An entire playerState for 2 players might look like this:
     * "A20Ma02a13b00e42S2a13e44a1FaabbeB30Mc01b11d21S0e12b2F"
     * If we split player A's string into its substrings, we get:
     * [A][20][Ma02a13b00e42][S2a13e44a1][Faabbe].
     *
     * @param playerState the player state string
     * @return True if the playerState is well-formed,
     * false if the playerState is not well-formed
     * TASK 3
     */

    /**
     * @Author: Xuanchen Wang
     */

    public static boolean isPlayerStateWellFormed(String playerState) {
        // FIXME Task 3
        //Creat a  StringBuider to build the mosaic part of the reg
        StringBuilder M = new StringBuilder("M");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String tmp = "([a-e]" + i + j + ")?";
                M.append(tmp);
            }
        }
        //Creat a StringBuilder to build the storage part of the reg
        StringBuilder S = new StringBuilder("S");
        for (int i = 0; i < 5; i++) {
            String tmp = "(" + i + "[a-e][0-5])?";
            S.append(tmp);
        }
        //Creat a StringBuilder to build the floor part of the reg
        StringBuilder F = new StringBuilder("F");
        for (int i = 97; i < 102; i++) {
            String tmp = "(" + Character.toString(i) + ")*";
            F.append(tmp);

        }
        F.append("f?");
        //Build the reg
        String reg = "([A-D][0-9]+" + M.toString() + S.toString() + F.toString() + ")+$";
        return playerState.matches(reg);
    }

    /**
     * Given the gameState, draw a *random* tile from the bag.
     * If the bag is empty, refill the the bag with the discard pile and then draw a tile.
     * If the discard pile is also empty, return 'Z'.
     *
     * @param gameState the current game state
     * @return the tile drawn from the bag, or 'Z' if the bag and discard pile are empty.
     * TASK 5
     */

    /**
     * @Author: Xuanchen Wang
     */

    public static char drawTileFromBag(String[] gameState) {
        // FIXME Task 5
        List<Character> list = new ArrayList<>();//a list to store all the tiles
        String sharedstate = gameState[0];
        /*
         * get the tiles and add them to the list
         * */
        String reg = "B([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})D";
        //if the bag is empty, refill the bag with tiles in discard
        Pattern p = Pattern.compile("B0000000000D");
        Matcher m = p.matcher(sharedstate);
        if (m.find()) {
            String reg1 = "D(\\d+)";
            Pattern pa1 = Pattern.compile(reg1);
            Matcher ma = pa1.matcher(sharedstate);
            while (ma.find()) {
                //if the discard is empty, return Z
                if (ma.group(1).equals("0000000000")) {
                    return 'Z';
                }
                //refill the bag with tiles in discard
                sharedstate = sharedstate.replaceAll("0000000000", ma.group(1));
                sharedstate = sharedstate.replaceAll("D\\d+", "D0000000000");
            }
        }
        //add the tile to the list
        Pattern pa = Pattern.compile(reg);
        Matcher matcher = pa.matcher(sharedstate);
        while (matcher.find()) {
            for (int i = 97; i < 102; i++) {
                int num = Integer.parseInt(matcher.group(i - 96));
                for (int j = 0; j < num; j++) {
                    char tmp = (char) i;
                    list.add(tmp);
                }
            }
        }
        /*
         * Randomly select a tile
         * */
        Random r = new Random();
        return list.get(r.nextInt(list.size()));


    }

    /**
     * Given a state, refill the factories with tiles.
     * If the factories are not all empty, return the given state.
     *
     * @param gameState the state of the game.
     * @return the updated state after the factories have been filled or
     * the given state if not all factories are empty.
     * TASK 6
     */

    /**
     * @Author: Wangyi Li
     */

    public static String[] refillFactories(String[] gameState) {
        // FIXME Task 6
        String sharedState = gameState[0];

        // If the factories are all empty, refill the factories with tiles
        Pattern p = Pattern.compile("FC(f)?B");
        Matcher m = p.matcher(sharedState);
        if (m.find()) {
            Pattern p1 = Pattern.compile("B0000000000D");
            Matcher m1 = p1.matcher(sharedState);
            if (m1.find()) {
                String reg1 = "D(([0-2][0-9]){5})";

                Pattern pa1 = Pattern.compile(reg1);
                Matcher ma = pa1.matcher(sharedState);
                while(ma.find()){
                    if(ma.group(1).equals("0000000000")){ // ma.group(1)：Bag中的数据
                        return gameState;
                    }
                    sharedState = sharedState.replaceAll("0000000000", ma.group(1));
                    sharedState = sharedState.replaceAll("D(([0-2][0-9]){5})","D0000000000"); // \\d：任意数字
                }
            }
            // refill the factories with tiles
            StringBuilder F = new StringBuilder("F");
            for (int i = 0; i < 5; i++) {
                F.append(i);
                for (int j = 0; j < 4; j++) {
                    F.append(drawTileFromBag(gameState));
                }
            }
            String f = F.toString();
            gameState[0] = sharedState.replaceAll("F", f);

            // count the number of tiles take from Bag
            int num_A = 0;
            int num_B = 0;
            int num_C = 0;
            int num_D = 0;
            int num_E = 0;
            for (int i = 1; i < f.length(); i++) {
                switch (f.charAt(i)) {
                    case 'a' :
                        num_A++;
                        break;
                    case 'b' :
                        num_B++;
                        break;
                    case 'c' :
                        num_C++;
                        break;
                    case 'd' :
                        num_D++;
                        break;
                    case 'e' :
                        num_E++;
                        break;
                    default:
                }
            }
            // update the Bag
            String reg = "B([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})";
            Pattern pa = Pattern.compile(reg);
            Matcher matcher = pa.matcher(sharedState);
            int num[] = new int[5];
            while (matcher.find()) {
                for (int i = 0; i < 5; i++) {
                    num[i] = Integer.parseInt(matcher.group(i+1));
                }
                num[0] -= num_A;
                num[1] -= num_B;
                num[2] -= num_C;
                num[3] -= num_D;
                num[4] -= num_E;
            }
            StringBuilder B = new StringBuilder("B");
            for (int i = 0; i < 5; i++) {
                B.append(String.format("%02d", num[i]));
            }
            String b = B.toString();
            gameState[0] = gameState[0].replaceAll("B([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})", b);

            return gameState;
        }
        // If the factories are not all empty, return the given state.
        return gameState;
    }

    /**
     * Given a gameState for a completed game,
     * return bonus points for rows, columns, and sets.
     *
     * @param gameState a completed game state
     * @param player    the player for whom the score is to be returned
     * @return the number of bonus points awarded to this player for rows,
     * columns, and sets
     * TASK 7
     */

    /**
     * @Author: Wangyi Li
     */

    public static int getBonusPoints(String[] gameState, char player) {
        // FIXME Task 7
        String playerState = gameState[1];

        String reg = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})";
        Pattern p = Pattern.compile(reg); // 获取到正则表达式 reg：
        Matcher m = p.matcher(playerState);

        m.find();
        String a = m.group(1); // situation of mosaic

        String reg1 = "(\\d){2}";
        Pattern p1 = Pattern.compile(reg1);
        Matcher m1 = p1.matcher(a);

        // bonus points for rows and columns
        int sum_r = 0;
        int sum_c = 0;
        int[] counter1 = {0,0,0,0,0};
        int[] counter2 = {0,0,0,0,0};
        while (m1.find()) {
            int x1 = Integer.parseInt(m1.group())/10; // rows
            int x2 = Integer.parseInt(m1.group())%10; // columns

            switch (x1) {
                case 0:
                    counter1[0]++;
                    break;
                case 1:
                    counter1[1]++;
                    break;
                case 2:
                    counter1[2]++;
                    break;
                case 3:
                    counter1[3]++;
                    break;
                case 4:
                    counter1[4]++;
                    break;
                default:
            }
            switch (x2) {
                case 0:
                    counter2[0]++;
                    break;
                case 1:
                    counter2[1]++;
                    break;
                case 2:
                    counter2[2]++;
                    break;
                case 3:
                    counter2[3]++;
                    break;
                case 4:
                    counter2[4]++;
                    break;
                default:
            }
        }
        for (int k : counter1) {
            if (k == 5) {
                sum_r += 2;
            }
        }
        for (int j : counter2) {
            if (j == 5) {
                sum_c += 7;
            }
        }

        // bonus points for sets.
        String reg2 = "[a-e]";
        Pattern p2 = Pattern.compile(reg2);
        Matcher m2 = p2.matcher(a);

        int sum_s = 0;
        int[] counter = {0,0,0,0,0};
        while (m2.find()) {
            switch (m2.group()) {
                case "a":
                    counter[0]++;
                    break;
                case "b":
                    counter[1]++;
                    break;
                case "c":
                    counter[2]++;
                    break;
                case "d":
                    counter[3]++;
                    break;
                case "e":
                    counter[4]++;
                    break;
                default:
            }
        }
        for (int j : counter) {
            if (j == 5) {
                sum_s += 10;
            }
        }
        return sum_r + sum_c + sum_s;
    }

    /**
     * Given a valid gameState prepare for the next round.
     * 1. Empty the floor area for each player and adjust their score accordingly (see the README).
     * 2. Refill the factories from the bag.
     * * If the bag is empty, refill the bag from the discard pile and then
     * (continue to) refill the factories.
     * * If the bag and discard pile do not contain enough tiles to fill all
     * the factories, fill as many as possible.
     * * If the factories and centre contain tiles other than the first player
     * token, return the current state.
     *
     * @param gameState the game state
     * @return the state for the next round.
     * TASK 8
     */
    /**
     * @Author: Zixin Feng
     */
    public static String[] nextRound(String[] gameState) {
        // FIXME TASK 8
            String sharedState = gameState[0].substring(0);
            String playerState = gameState[1].substring(0);
            String[] result = {sharedState, playerState};
            boolean isStorageFull = false;
            boolean isEndOfGame = false;
            Map<Integer, Integer> rows = new HashMap<>(); //a map to store the number of tile in each row in mosaic
            /*
             * If the factories and centre contain tiles other than the first player
             * token, return the current state
             * */
            Pattern p = Pattern.compile("Cf?B");
            Matcher m = p.matcher(sharedState);
            String refilledFactory = refillFactories(result)[0]; //refill the factory
            /*
             *  if one of the rows in the storage area is full
             * */
            Pattern ps = Pattern.compile("S(([0-4][a-e][1-5])*)F");
            Matcher ms = ps.matcher(playerState);
            while (ms.find()) {
                for (int i = 0; i < ms.group(1).length(); i += 3) {
                    int rowIndex = Integer.parseInt(Character.toString(ms.group(1).charAt(i)));
                    int tilenumber = Integer.parseInt(Character.toString(ms.group(1).charAt(i + 2)));
                    if (tilenumber == rowIndex + 1) {
                        isStorageFull = true;
                        break;
                    }
                }
            }
            /*
             * If one of the row in mosaic is full
             * */
            Pattern pm = Pattern.compile("M(([a-e][0-4][0-4])*)S");
            Matcher mm = pm.matcher(playerState);
            while (mm.find()) {
                for (int i = 0; i < 5; i++) {
                    rows.put(i, 0);
                }
                for (int i = 1; i < mm.group(1).length(); i += 3) {
                    int tmp = Integer.parseInt(Character.toString(mm.group(1).charAt(i)));
                    rows.put(tmp, rows.get(tmp) + 1);
                }
                for (int tmp : rows.values()) {
                    if (tmp == 5) {
                        isEndOfGame = true;
                    }
                }
            }


            if (!m.find() || sharedState.equals(refilledFactory) || isStorageFull) {
                return gameState;
            }
            if (isEndOfGame) {
                Pattern p1 = Pattern.compile("F([a-f]*)");
                Matcher m1 = p1.matcher(playerState);
                Map<Character, Integer> tiles = new HashMap<>();
                for (char c = 'a'; c < 'g'; c++) {
                    tiles.put(c, 0);
                }
                /*
                 * get the tiles from floor
                 * */
                while (m1.find()) {
                    for (int i = 0; i < m1.group(1).length(); i++) {
                        char tile = m1.group(1).charAt(i);
                        tiles.put(tile, tiles.get(tile) + 1);
                    }
                }
                tiles.remove('f');
                Pattern pd = Pattern.compile("D(\\d*)");
                Matcher md = pd.matcher(sharedState);
                StringBuilder discard = new StringBuilder("D");
                while (md.find()) {
                    int counter = 0;
                    for (int i = 0; i < md.group(1).length(); i += 2) {
                        int number = Integer.parseInt(md.group(1).substring(i, i + 2));
                        number += tiles.get((char) (counter + 97));
                        if (number < 10) {
                            discard.append(0);
                        }
                        discard.append(number);
                        counter++;
                    }
                }
                sharedState = sharedState.replaceAll("D\\d*", discard.toString());
                sharedState = sharedState.replace("C", "Cf");
                result[0] = sharedState;
                return calculatePoints(isEndOfGame, playerState, result);
            }

            if (refilledFactory.startsWith("A")) {
                Pattern pf = Pattern.compile("F([a-f]*)B");
                Matcher mf = pf.matcher(playerState);
                while (mf.find()) {
                    if (!mf.group(1).endsWith("f")) {
                        refilledFactory = refilledFactory.replaceFirst("^A", "B");
                    }
                }
            } else if (!playerState.endsWith("f")) {
                refilledFactory = refilledFactory.replaceFirst("^B", "A");
            }
            result[0] = refilledFactory;

            return calculatePoints(isEndOfGame, playerState, result);
        }

    private static String[] calculatePoints(boolean isEndOfGame, String playerState, String[] result) {
        /*
         * update the state of player1
         * */
        int number = 0; //the number of tiles in floor
        Pattern p1 = Pattern.compile("F([a-f]*)B");
        Matcher m1 = p1.matcher(playerState);
        while (m1.find()) {
            number = m1.end(1) - m1.start(1);
        }
        playerState = playerState.replaceAll("F[a-f]*B", "FB"); //empty the floor
        int penalty = 0;
        // calculate the penalty
        switch (number) {
            case 0 -> penalty -= 0;
            case 1 -> penalty -= 1;
            case 2 -> penalty -= 2;
            case 3 -> penalty -= 4;
            case 4 -> penalty -= 6;
            case 5 -> penalty -= 8;
            case 6 -> penalty -= 11;
            default -> penalty -= 14;
        }
        //update the score
        Pattern p2 = Pattern.compile("A(\\d*)M");
        Matcher m2 = p2.matcher(playerState);
        while (m2.find()) {
            int score = Integer.parseInt(m2.group(1));
            score += penalty;
            if (score < 0) {
                score = 0;
            }
            if (isEndOfGame) {
                score += getBonusPoints(result, 'A');
            }
            playerState = playerState.replaceAll("A\\d*M", "A" + score + "M");
        }
        result[1] = playerState;

        /*
         * update the state of player2
         * */
        number = 0; //the number of tiles in floor
        Pattern p3 = Pattern.compile("F([a-f]*)$");
        Matcher m3 = p3.matcher(playerState);
        while (m3.find()) {
            number = m3.end(1) - m3.start(1);
        }
        playerState = playerState.replaceAll("F[a-f]*$", "F"); //empty the floor
        penalty = 0;
        // calculate the penalty
        switch (number) {
            case 0 -> penalty -= 0;
            case 1 -> penalty -= 1;
            case 2 -> penalty -= 2;
            case 3 -> penalty -= 4;
            case 4 -> penalty -= 6;
            case 5 -> penalty -= 8;
            case 6 -> penalty -= 11;
            default -> penalty -= 14;
        }
        //update the score
        Pattern p4 = Pattern.compile("B(\\d*)M");
        Matcher m4 = p4.matcher(playerState);
        while (m4.find()) {
            int score = Integer.parseInt(m4.group(1));
            score += penalty;
            if (score < 0) {
                score = 0;
            }
            if (isEndOfGame) {
                score += getBonusPoints(result, 'B');
            }
            playerState = playerState.replaceAll("B\\d*M", "B" + score + "M");
        }
        result[1] = playerState;

        return result;
    }

    /**
     * Given an entire game State, determine whether the state is valid.
     * A game state is valid if it satisfies the following conditions.
     * <p>
     * [General]
     * 1. The game state is well-formed.
     * 2. There are no more than 20 of each colour of tile across all player
     * areas, factories, bag and discard
     * 3. Exactly one first player token 'f' must be present across all player
     * boards and the centre.
     * <p>
     * [Mosaic]
     * 1. No two tiles occupy the same location on a single player's mosaic.
     * 2. Each row contains only 1 of each colour of tile.
     * 3. Each column contains only 1 of each colour of tile.
     * [Storage]
     * 1. The maximum number of tiles stored in a row must not exceed (row_number + 1).
     * 2. The colour of tile stored in a row must not be the same as a colour
     * already found in the corresponding row of the mosaic.
     * <p>
     * [Floor]
     * 1. There are no more than 7 tiles on a single player's floor.
     * [Centre]
     * 1. The number of tiles in the centre is no greater than 3 * the number of empty factories.
     * [Factories]
     * 1. At most one factory has less than 4, but greater than 0 tiles.
     * Any factories with factory number greater than this factory must contain 0 tiles.
     *
     * @param gameState array of strings representing the game state.
     *                  state[0] = sharedState
     *                  state[1] = playerStates
     * @return true if the state is valid, false if it is invalid.
     * TASK 9
     */

    /**
     * @Author: Zixin Feng + Wangyi Li
     */

    public static boolean isStateValid(String[] gameState) {
        // The game state is well-formed.
        if (!isSharedStateWellFormed(gameState[0])) {
            return false;
        }
        if (!isPlayerStateWellFormed(gameState[1])) {
            return false;
        }

        int factory_noEmpty_num = 0;
        if (isSharedStateWellFormed(gameState[0])){

            Pattern p = Pattern.compile("F(([0-4][a-e]{4}){0,5})C([a-f]*)B(([0-2][0-9]){5})D(([0-2][0-9]){5})");
            Matcher m = p.matcher(gameState[0]);

            int[] factory_tile_num = new int[5];
            int[] center_title_num = new int[6];
            while (m.find()){

                System.out.println(m.group(0));
                //factory
                String factory_tile = m.group(1).replaceAll("\\d+","");
                factory_noEmpty_num = m.group(1).length() / 5;
                for(int i = 0; i < factory_tile.length(); i++){

                    factory_tile_num[factory_tile.charAt(i)- 97]++;
                }



                Arrays.sort(factory_tile_num);

                if (factory_tile_num[factory_tile_num.length - 1] > 20){
                    System.out.println(1);
                    return  false;
                }

                //center
                String center_tile = m.group(3);
                for(int i = 0; i < center_tile.length(); i++){

                    center_title_num[center_tile.charAt(i)- 97]++;
                }

                Arrays.sort(center_title_num);

                if (center_title_num[center_title_num.length - 1] > 20){
                    System.out.println(2);
                    return  false;
                }

                //bag
                String bag_tile = m.group(4);
                for (int i = 0; i <bag_tile.length() - 1; i+=2){

                    if (((bag_tile.charAt(i) - '0') == 2 && (bag_tile.charAt(i + 1) - '0' > 0)) || ((bag_tile.charAt(i) - '0') > 2)){
                        System.out.println(3);
                        return false;

                    }

                }

                //discard
                String discard_tile = m.group(6);
                for (int i = 0; i <discard_tile.length() - 1; i+=2){

                    if (((discard_tile .charAt(i) - '0') == 2 && (discard_tile .charAt(i + 1) - '0' > 0)) || ((discard_tile .charAt(i) - '0') > 2)){
                        System.out.println(4);
                        return false;

                    }

                }


            }

        }

        if (isPlayerStateWellFormed(gameState[1])){

            String reg = "[A-D][0-9]{1,2}M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5]){0,5})F(([a-e]){0,7})C*(([a-e]){0,100})";
            Pattern p = Pattern.compile(reg);

            Matcher m = p.matcher(gameState[1]);



            while (m.find()){

                System.out.println(m.group(0));
                // System.out.println(m.group(1));
                //mosaic, No two tiles occupy the same location on a single player's mosaic
                int length = m.group().length() / 3;

                ArrayList<Integer> arrayList = new ArrayList<>();
                Map<String, String> mosaic_map = new HashMap<>();

                for(int i = 0; i < m.group(1).length() -1; i +=3){

                    String a = m.group(1).charAt(i + 1) + ""  + m.group(1).charAt(i + 2)  + "";

                    if (arrayList.contains(a)){
                        System.out.println(5);
                        return  false;
                    }

                    mosaic_map.put(m.group(1).charAt(i + 1) + "",m.group(1).charAt(i) + "");
                    //  mosaic_list.add(m.group(1).charAt(i));

                    arrayList.add(Integer.parseInt(a));

                }

                //Storage The maximum number of tiles stored in a row must not exceed (row_number + 1).
                String Storage = m.group(3);
                // System.out.println(Storage);
                //Storage region colour is different than the colour in Moscia
                // List<Character> color_list = new ArrayList<>();
                for (int i = 0; i < Storage.length() - 1;i += 3){

                    int row_num = Integer.parseInt(Storage.charAt(i) + "");
                    int tile_num = Integer.parseInt(Storage.charAt(i + 2) + "");

                    if (mosaic_map.get(Storage.charAt(i)+"") != null && mosaic_map.get(Storage.charAt(i)+"").equals(Storage.charAt(i + 1) + "")){
                        System.out.println(6);
                        // System.out.println(Storage.charAt(i + 1));
                        return  false;
                    }



                    //add color to list
                    //color_list.add(Storage.charAt(i + 1));

                    //The colour of tile stored in a row must not be the same as a colour
                    if (Storage.charAt(i + 1) < 97 || Storage.charAt(i + 1) > 122){
                        System.out.println(7);
                        // System.out.println(Storage.charAt(i) < 97);
                        return false;
                    }

                    if (tile_num > row_num + 1){

                        System.out.println(8);
                        return  false;
                    }


                }

                String floor = m.group(5);

                //There are no more than 7 tiles on a single player's floor.
                if (floor.length() >= 7){

                    System.out.println(9);
                    return  false;
                }




                String center = m.group(7);
                //The number of tiles in the centre is no greater than 3 * the number of empty factories.
                if (center.length() > 3 * (5 - factory_noEmpty_num))
                {
                    System.out.println(5 - factory_noEmpty_num);
                    System.out.println(10);
                    return false;
                }


            }
        }

        // The colour of tile stored in a row must not be the same as a colour already found in the corresponding row of the mosaic.
        if (!isTilesAmountRight(gameState)) {
            return false;
        }

        // The number of tiles in the centre is no greater than 3 * the number of empty v factories.
        String reg1 = "F(([0-4][a-e]{4}){0,5})C([a-f]*)B(([0-2][0-9]){5})D(([0-2][0-9]){5})";
        Pattern p1 = Pattern.compile(reg1);
        Matcher m1 = p1.matcher(gameState[0]);
        if (m1.find()) {
            if (m1.group(3).contains("f")) { // center
                if (m1.group(3).length() - 1 > 3* (5 - m1.group(1).length() / 5)) {
                    System.out.println(m1.group(3).length());
                    System.out.println(3* (5 - m1.group(1).length() / 5));
                    return false;
                }
            } else {
                if (m1.group(3).length() - 1 > 3* (5 - m1.group(1).length() / 5)) {
                    System.out.println(m1.group(3).length());
                    System.out.println(3* (5 - m1.group(1).length() / 5));
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isTilesAmountRight (String[] gameState) {
        int[] count = new int[5];

        String test = "";
        String reg1 = "F(([0-4][a-e]{4}){0,5})C([a-f]*)B(([0-2][0-9]){5})D(([0-2][0-9]){5})";
        Pattern p1 = Pattern.compile(reg1);
        Matcher m1 = p1.matcher(gameState[0]);
        if (m1.find()) {
            test = m1.group(1) + m1.group(3); // factory + center

            // bag
            String reg_b = "B([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])";
            Pattern p_b = Pattern.compile(reg_b);
            Matcher m_b = p_b.matcher(gameState[0]);
            if (m_b.find()) {
                count[0] += Integer.parseInt(m_b.group(1));
                count[1] += Integer.parseInt(m_b.group(2));
                count[2] += Integer.parseInt(m_b.group(3));
                count[3] += Integer.parseInt(m_b.group(4));
                count[4] += Integer.parseInt(m_b.group(5));
            }

            // discard
            String reg_d = "D([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])";
            Pattern p_d = Pattern.compile(reg_d);
            Matcher m_d = p_d.matcher(gameState[0]);
            if (m_d.find()) {
                count[0] += Integer.parseInt(m_d.group(1));
                count[1] += Integer.parseInt(m_d.group(2));
                count[2] += Integer.parseInt(m_d.group(3));
                count[3] += Integer.parseInt(m_d.group(4));
                count[4] += Integer.parseInt(m_d.group(5));
            }
        }

        String reg2 = "M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)F(f?([a-e])*)";
        Pattern p2 = Pattern.compile(reg2);
        Matcher m2 = p2.matcher(gameState[1]);
        while (m2.find()) { // mosaic
            String reg_m = "([a-e][0-4][0-4])";
            Pattern p_m = Pattern.compile(reg_m);
            Matcher m_m = p_m.matcher(m2.group(1));
            while (m_m.find()) {
                switch (m_m.group().charAt(0) - 97) {
                    case 0:
                        count[0]++;
                        break;
                    case 1:
                        count[1]++;
                        break;
                    case 2:
                        count[2]++;
                        break;
                    case 3:
                        count[3]++;
                        break;
                    case 4:
                        count[4]++;
                        break;
                }
            }

            String reg_s = "([0-4][a-e][0-5])";
            Pattern p_s = Pattern.compile(reg_s);
            Matcher m_s = p_s.matcher(m2.group(3));
            while (m_s.find()) {
                switch (m_s.group().charAt(1) - 97) {
                    case 0:
                        count[0] += Integer.parseInt("" + m_s.group().charAt(2));
                        break;
                    case 1:
                        count[1] += Integer.parseInt("" + m_s.group().charAt(2));
                        break;
                    case 2:
                        count[2] += Integer.parseInt("" + m_s.group().charAt(2));
                        break;
                    case 3:
                        count[3] += Integer.parseInt("" + m_s.group().charAt(2));
                        break;
                    case 4:
                        count[4] += Integer.parseInt("" + m_s.group().charAt(2));
                        break;
                }
            }

            test += m2.group(5); // floor
        }

        // count factory center & floor
        for (int i = 0; i < test.length(); i++) {
            switch (test.charAt(i) - 97) {
                case 0:
                    count[0]++;
                    break;
                case 1:
                    count[1]++;
                    break;
                case 2:
                    count[2]++;
                    break;
                case 3:
                    count[3]++;
                    break;
                case 4:
                    count[4]++;
                    break;
                default:
                    break;
            }
        }
        if (count[0] == 20 && count[1] == 20 && count[2] == 20 && count[3] == 20 && count[4] == 20) {
            return true;
        }
        return false;
    }

    /**
     * Given a valid gameState and a move, determine whether the move is valid.
     * A Drafting move is a 4-character String.
     * A Drafting move is valid if it satisfies the following conditions:
     * <p>
     * 1. The specified factory/centre contains at least one tile of the specified colour.
     * 2. The storage row the tile is being placed in does not already contain a different colour.
     * 3. The corresponding mosaic row does not already contain a tile of that colour.
     * Note that the tile may be placed on the floor.
     * </p>
     * <p>
     * A Tiling move is a 3-character String.
     * A Tiling move is valid if it satisfies the following conditions:
     * 1. The specified row in the Storage area is full.
     * 2. The specified column does not already contain a tile of the same colour.
     * 3. The specified location in the mosaic is empty.
     * 4. If the specified column is 'F', no valid move exists from the
     * specified row into the mosaic.
     * </p>
     *
     * @param gameState the game state.
     * @param move      A string representing a move.
     * @return true if the move is valid, false if it is invalid.
     * TASK 10
     */

    /**
     * @Author: Wangyi Li
     */

    public static boolean isMoveValid(String[] gameState, String move) {
        // FIXME Task 10
        String sharedState = gameState[0];
        String playerState = gameState[1];
        if (sharedState.charAt(0) != move.charAt(0)){ // player validation
            return false;
        }
        if (move.length() == 4) { // Drafting move: 4-character string
            // 1. The specified factory/centre contains at least one tile of the specified colour.
            String reg = "F(([0-4][a-e]{4}){0,5})C([a-f]*)";
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(sharedState);
            String colourStr = move.charAt(2) + "";
            if (m.find()) {
                String center = m.group(3);
                String factory = m.group(1);
                if (move.charAt(1) == 'C') { // from center
                    if (!center.contains(colourStr)) {
                        return false;
                    }
                } else { // from factory
                    String reg_f = move.charAt(1) + "[a-e]{4}";
                    Pattern p_f = Pattern.compile(reg_f);
                    Matcher m_f = p_f.matcher(factory);
                    if (m_f.find()) {
                        if (!m_f.group().contains(colourStr)) {
                            return false;
                        }
                    }
                }
            }

            // 2. The storage row the tile is being placed in does not already contain a different colour.
            char player = move.charAt(0);
            char colour = move.charAt(2);
            char destination = move.charAt(3);

            String reg1 = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)F(f?([a-e])*)";
            Pattern p1 = Pattern.compile(reg1);
            Matcher m1 = p1.matcher(playerState);
            if (m1.find()) {
                String storage = m1.group(3);
                if (destination !='F') {
                    String reg_s = destination + "[a-e][0-5]";
                    Pattern p_s = Pattern.compile(reg_s);
                    Matcher m_s = p_s.matcher(storage);
                    if (m_s.find()) {
                        String storageRow = m_s.group();
                        if (storageRow.charAt(1) != colour) {
                            return false;
                        }
                    }
                }

                // 3. The corresponding mosaic row does not already contain a tile of that colour.
                String mosaic = m1.group(1);
                String reg2 = "[a-e]" + move.charAt(3) +"[0-4]";
                Pattern p2 = Pattern.compile(reg2);
                Matcher m2 = p2.matcher(mosaic);
                while (m2.find()) {
                    if (m2.group().charAt(0) == colour) {
                        return false;
                    }
                }

                // full storage
                String reg3 = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)";
                Pattern p3 = Pattern.compile(reg3);
                Matcher m3 = p3.matcher(playerState);
                if (m3.find()) {
                    String reg_s = "([0-4][a-e][0-5])";
                    Pattern p_s = Pattern.compile(reg_s);
                    Matcher m_s = p_s.matcher(m3.group(3));

                    while (m_s.find()) {
                        if (move.charAt(3) == m_s.group().charAt(0) && m_s.group().charAt(0)+1 == m_s.group().charAt(2)) {
                             return false;
                        }
                    }
                }

            }

        } else if (move.length() == 3) { // Tiling move: 3-character string

            // 1. The specified row in the Storage area is full.
            char player = move.charAt(0);
            char storageRow = move.charAt(1);
            char mosaicColumn = move.charAt(2);
            char colour;

            String reg1 = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)F(f?([a-e])*)";
            Pattern p1 = Pattern.compile(reg1);
            Matcher m1 = p1.matcher(playerState);
            if (m1.find()) {
                String storage = m1.group(3);
                String reg_s = storageRow + "[a-e][0-5]";
                Pattern p_s = Pattern.compile(reg_s);
                Matcher m_s = p_s.matcher(storage);
                if (m_s.find()) {
                    int rowMax = (int)storageRow + 1;
                    if (m_s.group().charAt(2) != (char)rowMax) { // not full
                        return false;
                    }
                    colour = m_s.group().charAt(1);
                } else {
                    return false;
                }

                // 2. The specified column does not already contain a tile of the same colour.
                String mosaic = m1.group(1);

                String reg2 = "[a-e][0-4]" + mosaicColumn;
                Pattern p2 = Pattern.compile(reg2);
                Matcher m2 = p2.matcher(mosaic);
                while (m2.find()) {
                    if (m2.group().charAt(0) == colour) {
                        return false;
                    }
                }

                // 3. The specified location in the mosaic is empty.
                String reg3 = "[a-e]" + storageRow + mosaicColumn;
                Pattern p3 = Pattern.compile(reg3);
                Matcher m3 = p3.matcher(mosaic);
                if (m3.find()) {
                    return false;
                }

                // 4. If the specified column is 'F', no valid move exists from the specified row into the mosaic.
                if (move.charAt(2) == 'F') {
                    List<Character> record = new ArrayList<>();

                    // record the available column
                    String reg4 = colour + "[0-4][0-4]";
                    Pattern p4 = Pattern.compile(reg4);
                    Matcher m4 = p4.matcher(mosaic);
                    while (m4.find()) {
                        record.add(m4.group().charAt(2));
                    }

                    // record the column which has been occupied
                    String reg5 = "[a-e]" + storageRow + "[0-4]";
                    Pattern p5 = Pattern.compile(reg5);
                    Matcher m5 = p5.matcher(mosaic);
                    while (m5.find()) {
                        record.add(m5.group().charAt(2));
                    }

                    record.sort((o1, o2) -> o1 - o2);
                    if (record.size() != 5) {
                        return false;
                    }
                    for (int i = 0; i < record.size(); i++) {
                        if ((int)record.get(i)-48 != i){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Given a gameState and a move, apply the move to the gameState.
     * If the move is a Tiling move, you must also update the player's score.
     * If the move is a Tiling move, you must also empty the remaining tiles
     * into the discard.
     * If the move is a Drafting move, you must also move any remaining tiles
     * from the specified factory into the centre.
     * If the move is a Drafting move and you must put tiles onto the floor,
     * any tiles that cannot fit on the floor are placed in the discard with
     * the following exception:
     * If the first player tile would be placed into the discard, it is instead
     * swapped with the last tile in the floor, when the floor is sorted
     * alphabetically.
     *
     * @param gameState the game state.
     * @param move      A string representing a move.
     * @return the updated gameState after the move has been applied.
     * TASK 11
     */

    /**
     * @Author: Wangyi Li
     */

    public static String[] applyMove(String[] gameState, String move) {
        // FIXME Task 11
        String sharedState = gameState[0];
        String playerState = gameState[1];

        if (move.length() == 4) { // Drafting move: 4-character string
            char player = move.charAt(0);
            char pickTileFrom = move.charAt(1); // from Factory/Center
            char selectedColour = move.charAt(2);
            char putTileTo = move.charAt(3); // to storageRow/Floor

            String reg_c = "C[a-f]*";
            Pattern p_c = Pattern.compile(reg_c);
            Matcher m_c = p_c.matcher(sharedState);

            int count = 0; // count for same colour will be taken
            String updatedCenter = "";
            boolean putOnFloor = false; // determine whether need to put on floor
            List<Character> addToXList = new ArrayList<>(); // use on floor part

            if (pickTileFrom == 'C') { // pick from center
                if (m_c.find()){
                    for (int i = 1; i < m_c.group().length(); i++) {
                        if (m_c.group().charAt(i) == selectedColour) {
                            count++;
                        }
                    }
                    // generate addToXList
                    for (int i = 0; i < count; i++) {
                        addToXList.add(selectedColour);
                    }
                    if (m_c.group().contains("f")) { // the 1st one take tiles from center
                        updatedCenter = m_c.group().replaceAll("" + selectedColour, "").replaceAll("f", "");
                        // take f to the floor
                        putOnFloor = true;
                        addToXList.add('f');
                    } else {
                        updatedCenter = m_c.group().replaceAll("" + selectedColour, "");
                    }
                    gameState[0] = gameState[0].replaceAll("C[a-f]*", updatedCenter);

                }
            } else { // pick tiles from factory
                String reg_f = pickTileFrom + "[a-e]{4}";
                Pattern p_f = Pattern.compile(reg_f);
                Matcher m_f = p_f.matcher(sharedState);
                if (m_f.find()) {
                    List<String> aFactory = new ArrayList<>();
                    for (int i = 1; i < 5; i++) {
                        if (m_f.group().charAt(i) == selectedColour) {
                            count++;
                        } else {
                            aFactory.add("" + m_f.group().charAt(i));
                        }
                    }

                    // // 1. move any remaining tiles from the specified factory into the centre.
                    if (m_c.find()) {
                        List<String> centerList = new ArrayList<>();
                        for (int i = 1; i < m_c.group().length(); i++) {
                            centerList.add("" + m_c.group().charAt(i));
                        }
                        centerList.addAll(aFactory);
                        Collections.sort(centerList);
                        centerList.add(0,"C");

                        updatedCenter = "";
                        for (int i = 0; i < centerList.size(); i++) {
                            updatedCenter += centerList.get(i);
                        }
                    }
                    gameState[0] = gameState[0].replaceAll("C[a-f]*", updatedCenter); // update center
                    gameState[0] = gameState[0].replaceAll(m_f.group(), ""); // update factory

                    // generate addToXList
                    for (int i = 0; i < count; i++) {
                        addToXList.add(selectedColour);
                    }
                }
            }


            String reg = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)F(f?([a-e])*)";
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(playerState);

            // Discard part
            String reg_d = "D([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])";
            Pattern p_d = Pattern.compile(reg_d);
            Matcher m_d = p_d.matcher(sharedState);

            if (m.find()) {
                if (putTileTo != 'F') { // from move string -put to storage
                    int storageRow = putTileTo;
                    List<String> storageList = new ArrayList<>();

                    String reg_s1 = "[0-4][a-e][0-5]";
                    Pattern p_s1 = Pattern.compile(reg_s1);
                    Matcher m_s1 = p_s1.matcher(m.group(3));

                    int currentNum = 0; // record current tile in the pointed row in storage
                    boolean isEmpty = true;
                    while (m_s1.find()) {
                        storageList.add(m_s1.group());
                        if (m_s1.group().charAt(0) == storageRow) {
                            currentNum = m_s1.group().charAt(2) - 48;
                            isEmpty = false; // the row is already have tiles
                        }
                    }
                    // the remaining space in pointed row
                    int availableSpace = (storageRow-48) - currentNum + 1;

                    String updatedStorage = "S";
                    String replacedRow = "";
                    if (isEmpty) { // there is no tile in pointed row
                        if (availableSpace < count) { // have overflow
                            replacedRow = "" + (char)storageRow + selectedColour + (char)(storageRow+1);
                            // should put excess part on floor
                            putOnFloor = true;
                            // delete the already put tiles
                            for (int i = 0; i < availableSpace; i++) {
                                addToXList.remove(0);
                            }
                        } else {
                            replacedRow = "" + (char) storageRow + selectedColour + count;
                            if (putOnFloor) { // if there is f taken from center
                                for (int i = 0; i < count; i++) {
                                    addToXList.remove(0);
                                }
                            }
                        }
                        storageList.add(replacedRow);
                        Collections.sort(storageList);
                    } else {
                        int index = 0;
                        int newNum = 0; // the current number of tiles + new tiles

                        if (availableSpace == 0) { // the row is full
                            putOnFloor = true; // put on floor
                        } else if (availableSpace < count) { // have overflow
                            for (int i = 0; i < storageList.size(); i++) {
                                if (storageList.get(i).charAt(0) == storageRow) {
                                    index = i;
                                }
                            }
                            replacedRow = storageList.get(index).replaceAll("" + selectedColour + currentNum, "" + selectedColour + (storageRow-47));
                            storageList.set(index, replacedRow);
                            // put overflow on floor
                            putOnFloor = true;
                            for (int i = 0; i < availableSpace; i++) {
                                addToXList.remove(0);
                            }
                        } else if (availableSpace >= count) { // enough to put on row
                            for (int i = 0; i < storageList.size(); i++) {
                                if (storageList.get(i).charAt(0) == storageRow) {
                                    index = i;
                                }
                            }
                            newNum= currentNum + count;
                            replacedRow = storageList.get(index).replaceAll("" + selectedColour + currentNum, "" + selectedColour + newNum);
                            storageList.set(index, replacedRow);
                            // if there is f need to update to floor
                            if (putOnFloor) {
                                for (int i = 0; i < count; i++) {
                                    addToXList.remove(0);
                                }
                            }
                        }
                    }

                    for (int i = 0; i < storageList.size(); i++) {
                        updatedStorage += storageList.get(i);
                    }
                    String reg2 = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})";
                    Pattern p2 = Pattern.compile(reg2);
                    Matcher m2 = p2.matcher(gameState[1]);
                    if (m2.find()) {
                        gameState[1] = gameState[1].replaceAll(player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)", m2.group() + updatedStorage);
                    }
                }


                if (putTileTo == 'F' || putOnFloor) { // put on floor
                    List<Character> floorList = new ArrayList<>();
                    for (int i = 0; i < m.group(5).length(); i++) {
                        floorList.add(m.group(5).charAt(i));
                    }

                    floorList.addAll(addToXList);
                    int[] countByColour = new int[5];
                    String updatedFloor = "F";
                    // the tile is over 7 in floor
                    if (floorList.size() > 7) {
                        for (int i = 7; i < floorList.size(); i++) {
                            if (floorList.get(i) == 'f') {
                                char temp = floorList.get(6);
                                floorList.set(6, 'f');
                                floorList.set(i, temp);
                            }
                        }
                        for (int i = 7; i < floorList.size(); i++) {
                            System.out.println(floorList.get(i) - 97);
                            switch (floorList.get(i) - 97) {
                                case 0:
                                    countByColour[0]++;
                                    break;
                                case 1:
                                    countByColour[1]++;
                                    break;
                                case 2:
                                    countByColour[2]++;
                                    break;
                                case 3:
                                    countByColour[3]++;
                                    break;
                                case 4:
                                    countByColour[4]++;
                                    break;
                            }
                        }
                        List<Integer> discardList = new ArrayList<>();
                        while (m_d.find()) {
                            for (int i = 1; i < 6; i++) {
                                discardList.add(Integer.parseInt(m_d.group(i)));
                            }
                        }
                        String updatedDiscard = "D";
                        for (int i = 0; i < countByColour.length; i++) {
                            if ((countByColour[i] + discardList.get(i)) < 10) {
                                updatedDiscard += "0" + (countByColour[i] + discardList.get(i));
                            } else {
                                updatedDiscard += (countByColour[i] + discardList.get(i));
                            }
                        }
                        gameState[0] = gameState[0].replaceAll("D([0-2][0-9]){5}", updatedDiscard);

                        List<Character> updatedFloorList = new ArrayList<>();
                        for (int i = 0; i < 7; i++) {
                            updatedFloorList.add(i, floorList.get(i));
                        }
                        Collections.sort(updatedFloorList);
                        for (int i = 0; i < updatedFloorList.size(); i++) {
                            updatedFloor += updatedFloorList.get(i);
                        }
                    } else {
                        Collections.sort(floorList);
                        for (int i = 0; i < floorList.size(); i++) {
                            updatedFloor += floorList.get(i);
                        }
                    }
                    String reg1 = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)";
                    Pattern p1 = Pattern.compile(reg1);
                    Matcher m1 = p1.matcher(gameState[1]);
                    if (m1.find()) {
                        gameState[1] = gameState[1].replaceAll(player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)F(f?([a-e])*)", m1.group() + updatedFloor);
                    }
                }
            }
            if (!gameState[0].contains(player + "FCB")) {
                char nextPlayer = 0;
                if (player == 'A') {
                    nextPlayer = 'B';
                } else {
                    nextPlayer = 'A';
                }
                gameState[0] = gameState[0].replaceAll("" + player + "F", "" + nextPlayer + "F");
            }


        } else if (move.length() == 3) { // Tiling move: 3-character string
            char player = move.charAt(0);
            char storageRow = move.charAt(1);
            char mosaicColumn = move.charAt(2);

            // the specified player
            String reg1 = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)F(f?([a-e])*)"; // 截取当前玩家的状态
            Pattern p1 = Pattern.compile(reg1);
            Matcher m1 = p1.matcher(playerState);

            if (m1.find()) {
                String mosaic = m1.group(1);
                String storage = m1.group(3);
                // storageRow
                String reg_s = storageRow + "[a-e][0-5]";
                Pattern p_s = Pattern.compile(reg_s);
                Matcher m_s = p_s.matcher(storage);
                char colour = 0;
                if (m_s.find()) {
                    colour = m_s.group().charAt(1);
                }

                // scoring
                int count = 0; // the total count of row and column score
                if (m1.group(1).equals("")) {
                    count = 1;
                } else {
                    String reg_r = storageRow + "[0-4]";
                    Pattern p_r = Pattern.compile(reg_r);
                    Matcher m_r = p_r.matcher(mosaic);

                    List<Integer> row = new ArrayList<>();
                    while (m_r.find()) {
                        row.add(m_r.group().charAt(1) - 48);
                    }
                    // row
                    int countRow = 1;
                    for (int i = 1; mosaicColumn - 48 + i < 5; i++) {
                        if (row.contains(mosaicColumn - 48 + i)) {
                            countRow++;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; mosaicColumn - 48 - i >= 0; i++) {
                        if (row.contains(mosaicColumn - 48 - i)) {
                            countRow++;
                        } else {
                            break;
                        }
                    }

                    // column
                    int countColumn = 1;
                    String reg_c = "[0-4]" + mosaicColumn;
                    Pattern p_c = Pattern.compile(reg_c);
                    Matcher m_c = p_c.matcher(mosaic);

                    List<Integer> column = new ArrayList<>();
                    while (m_c.find()) {
                        column.add(m_c.group().charAt(0) - 48);
                    }
                    for (int i = 1; storageRow - 48 + i < 5; i++) {
                        if (column.contains(storageRow - 48 + i)) {
                            countColumn++;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; storageRow - 48 - i >= 0; i++) {
                        if (column.contains(storageRow - 48 - i)) {
                            countColumn++;
                        } else {
                            break;
                        }
                    }

                    // total count
                    if (countColumn == 1 && countRow == 1) {
                        count = 1;
                    } else if (countColumn == 1 || countRow == 1) {
                        count = countColumn + countRow - 1;
                    } else {
                        count = countColumn + countRow;
                    }
                }

                // update score
                String reg = player + "([0-9]+)";
                Pattern p = Pattern.compile(reg);
                Matcher m = p.matcher(playerState);
                int updateScore = 0;
                if (m.find()) {
                    int oriScore = Integer.parseInt(m.group(1)); // 读取以前的分数转化为
                    updateScore = oriScore + count;
                }


                // mosaic
                String reg2 = "[a-e][0-4][0-4]";
                Pattern p2 = Pattern.compile(reg2);
                Matcher m2 = p2.matcher(mosaic);
                List<String> mosaicList = new ArrayList<>();
                while (m2.find()) {
                    mosaicList.add(m2.group());
                }
                String updateTile = "" + colour + storageRow + mosaicColumn;
                mosaicList.add(updateTile);
                Collections.sort(mosaicList, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        String n1 = "" + o1.charAt(1) + o1.charAt(2);
                        String n2 = "" + o2.charAt(1) + o2.charAt(2);
                        if (Integer.parseInt(n1) < Integer.parseInt(n2)) {
                            return -1;
                        }
                        return 1;
                    }
                });

                String updatedMosaic = "M";
                for (int i = 0; i < mosaicList.size(); i++) {
                    updatedMosaic += mosaicList.get(i);
                }

                // 2. If the move is a Tiling move, you must also empty the remaining tiles into the discard.
                List<String> storageList = new ArrayList<>();
                String reg_s2 = "[0-4][a-e][0-5]";
                Pattern p_s2 = Pattern.compile(reg_s2);
                Matcher m_s2 = p_s2.matcher(storage);
                while (m_s2.find()) {
                    if (m_s2.group().charAt(0) != storageRow) {
                        storageList.add(m_s2.group());
                    }
                }
                String replaceStorage = "S";
                for (int i = 0; i < storageList.size(); i++) {
                    replaceStorage += storageList.get(i);
                }
                gameState[1] = gameState[1].replaceAll(player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)", "" + player + updateScore + updatedMosaic + replaceStorage); // 清空storage对应行的栏

                // update discard
                String reg_d = "D([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])([0-2][0-9])";
                Pattern p_d = Pattern.compile(reg_d);
                Matcher m_d = p_d.matcher(sharedState);
                if (m_d.find()) {
                    int oriTileAmount = Integer.parseInt(m_d.group(colour - 96)); // 96：a, 97:b, 98:c, 99:d, 100:e
                    int updateTileAmount = oriTileAmount + (storageRow - 48); // 48: 0, 49: 1, 50: 2, 51: 3, 52: 4
                    // adjust format
                    String replacedTileAmount = "";
                    if (updateTileAmount < 10) {
                        replacedTileAmount = "0" + updateTileAmount;
                    } else {
                        replacedTileAmount = "" + updateTileAmount;
                    }
                    List<String> discardList = new ArrayList<>();
                    for (int i = 1; i <= 5; i++) {
                        discardList.add(m_d.group(i));
                    }
                    discardList.set(colour - 97, replacedTileAmount);

                    String replacement = "D";
                    for (int i = 0; i < 5; i++) {
                        replacement += discardList.get(i);
                    }
                    gameState[0] = gameState[0].replaceAll(reg_d, replacement);
                }

                String reg_new = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)";
                Pattern p_new = Pattern.compile(reg_new);
                Matcher m_new = p_new.matcher(gameState[1]);
                if (m_new.find()) {
                    String updatedStorage = m_new.group(3);
                    String reg_s1 = "[0-4][a-e][0-5]";
                    Pattern p_s1 = Pattern.compile(reg_s1);
                    Matcher m_s1 = p_s1.matcher(updatedStorage);
                    int flagCount = 0;
                    while (m_s1.find()) {
                        if ((char) (m_s1.group().charAt(0) + 1) == m_s1.group().charAt(2)) {
                            flagCount++;
                        }
                    }
                    char nextPlayer = 0;
                    if (player == 'A') {
                        nextPlayer = 'B';
                    } else {
                        nextPlayer = 'A';
                    }
                    if (flagCount == 0) {
                        gameState[0] = gameState[0].replaceAll("" + player + "F", "" + nextPlayer + "F");
                    }
                }
            }
        }
        return gameState;
    }

    /**
     * Given a valid game state, return a valid move.
     *
     * @param gameState the game state
     * @return a move for the current game state.
     * TASK 13
     */

    /**
     * @Author: Wangyi Li & Zixin Feng
     */

    public static String generateAction(String[] gameState) {
        // FIXME Task 13
        boolean tillingMove = false;
        if (gameState[0].contains("FCB")) {
            tillingMove = true;
        }
        String move = "";
        char player = 0;

        if (tillingMove) { // tilling
            // Tilling move: storage -> mosaic
            List<String> moveList = new ArrayList<>();
            player = gameState[0].charAt(0);

            String reg = player + "[0-9]+M(([a-e][0-4][0-4]){0,25})S(([0-4][a-e][0-5])*)";
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(gameState[1]);
            if (m.find()) {
                String reg_s = "([0-4][a-e][0-5])";
                Pattern p_s = Pattern.compile(reg_s);
                Matcher m_s = p_s.matcher(m.group(3));

                List<Character> rowList = new ArrayList<>();
                List<Character> colourList = new ArrayList<>();

                while (m_s.find()) { // find row information in storage
                    if (m_s.group().charAt(0)+1 == m_s.group().charAt(2)) {
                        rowList.add(m_s.group().charAt(0));
                        colourList.add(m_s.group().charAt(1));
                    }
                }

                boolean havePassed = false;
                StringBuilder singleMove = new StringBuilder("" + player);
                for (Character character : rowList) {
                    singleMove.append(character);
                    for (int j = 0; j < 5; j++) {
                        singleMove.append(j);
                        if (isMoveValid(gameState, singleMove.toString())) {
                            moveList.add(singleMove.toString());
                            havePassed = true;
                        }
                        singleMove = new StringBuilder("" + player + character);
                    }
                    if (havePassed) {
                        break;
                    }
                }
                Random r = new Random();
                int index = r.nextInt(moveList.size());
                move = moveList.get(index);
            }
        } else { // drafting
            player = gameState[0].charAt(0);

            List<String> singleMoveList = new ArrayList<>();
            List<String> moveList = new ArrayList<>();

            String reg = player + "F(([0-4][a-e]{4}){0,5})C([a-f]*)";
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(gameState[0]);
            if (m.find()) {
                if (m.group(3).equals("f")) { // no tiles on center, only take from factory
                    String reg_f = "([0-4][a-e]{4})";
                    Pattern p_f = Pattern.compile(reg_f);
                    Matcher m_f = p_f.matcher(m.group(1));
                    List<String> factoryList = new ArrayList<>();
                    while (m_f.find()) {
                        factoryList.add(m_f.group());
                    }
                    StringBuilder singleMove = new StringBuilder("" + player); // record possible move
                    // record all possible moves without duplicate
                    Set<String> singleMoveSet = new HashSet<>();
                    for (String s : factoryList) {
                        singleMove.append(s.charAt(0));
                        for (int j = 1; j < 5; j++) {
                            singleMove.append(s.charAt(j));
                            singleMoveSet.add(singleMove.toString());
                            singleMove = new StringBuilder("" + player + s.charAt(0));
                        }
                        singleMove = new StringBuilder("" + player);
                    }
                    System.out.println(singleMoveSet);
                    singleMoveList.addAll(singleMoveSet);
                } else { // center has other tiles except f
                    if (m.group(1).equals("")) { // factory is empty can only take from center
                        String singleMove = player + "C";
                        Set<String> centerSet = new HashSet<>();
                        for (int i = 0; i < m.group(3).length(); i++) {
                            if (m.group(3).charAt(i)!='f') {
                                centerSet.add(singleMove + m.group(3).charAt(i));
                            }
                        }
                        singleMoveList.addAll(centerSet);
                    } else { // can take from both factory and center
                        String reg_f = "([0-4][a-e]{4})";
                        Pattern p_f = Pattern.compile(reg_f);
                        Matcher m_f = p_f.matcher(m.group(1));
                        List<String> factoryList = new ArrayList<>();
                        while (m_f.find()) {
                            factoryList.add(m_f.group());
                        }
                        StringBuilder singleMove = new StringBuilder("" + player);
                        Set<String> singleMoveSet = new HashSet<>();
                        for (String s : factoryList) {
                            singleMove.append(s.charAt(0));
                            for (int j = 1; j < 5; j++) {
                                singleMove.append(s.charAt(j));
                                singleMoveSet.add(singleMove.toString());
                                singleMove = new StringBuilder("" + player + s.charAt(0));
                            }
                            singleMove = new StringBuilder("" + player);
                        }
                        singleMoveList.addAll(singleMoveSet);

                        String centerSingleMove = player + "C";
                        Set<String> centerSet = new HashSet<>();
                        for (int i = 0; i < m.group(3).length(); i++) {
                            if (m.group(3).charAt(i)!='f') {
                                centerSet.add(centerSingleMove + m.group(3).charAt(i));
                            }
                        }
                        singleMoveList.addAll(centerSet);
                    }
                }

                for (int i = 0; i < singleMoveList.size(); i++) {
                    for (int j = 0; j < 5; j++) {
                        if (isMoveValid(gameState, singleMoveList.get(i) + j)) {
                            moveList.add(singleMoveList.get(i) + j);
                        }
                    }
                    if (isMoveValid(gameState, singleMoveList.get(i) + "F")) {
                        moveList.add(singleMoveList.get(i) + "F");
                    }
                }
                System.out.println(moveList);
                Random r = new Random();
                int index = r.nextInt(moveList.size());
                move = moveList.get(index);
            }
        }
        return move;
        // FIXME Task 15 Implement a "smart" generateAction()
    }
}
