package com.example.sportquiz.data

import com.example.sportquiz.R
import com.example.sportquiz.domain.model.QuizLevel
import com.example.sportquiz.domain.model.QuizQuestion
import com.example.sportquiz.domain.model.SportCategory
import com.example.sportquiz.domain.model.User

object Database {

    val users = listOf(
        User("Paisley Morris", R.drawable.user_icon_default, 200),
        User("Hailey Kaufman", R.drawable.user_icon_default, 300),
        User("Kamari Wigginsa", R.drawable.user_icon_default, 400),
        User("Gideon Ballard", R.drawable.user_icon_default, 500),
        User("Jayda Martinez", R.drawable.user_icon_default, 600),
        User("Aliana Taylor", R.drawable.user_icon_default, 200),
        User("Eliana Keller", R.drawable.user_icon_default, 0),
        User("Perla Raymond", R.drawable.user_icon_default, 0)
    )

    val sportCategories = listOf(
        SportCategory("Basketball", R.drawable.category_basketball, R.drawable.basketball_poster),
        SportCategory("Hockey", R.drawable.categoty_hockey, R.drawable.hockey_poster),
        SportCategory("Football", R.drawable.category_football, R.drawable.football_poster),
        SportCategory("Karate", R.drawable.category_carate, R.drawable.karate_poster)
    )

    val quizLevels = listOf(
        QuizLevel(1, "Basketball"),
        QuizLevel(2, "Basketball"),
        QuizLevel(3, "Basketball"),
        QuizLevel(1, "Hockey"),
        QuizLevel(2, "Hockey"),
        QuizLevel(3, "Hockey"),
        QuizLevel(1, "Football"),
        QuizLevel(2, "Football"),
        QuizLevel(3, "Football"),
        QuizLevel(1, "Karate")
    )

    val quizQuestions = listOf(
        // Вопросы по категории "Basketball" и уровню 1
        QuizQuestion(
            "Basketball",
            1,
            "Which basketball team has won the most NBA championships?",
            listOf(
                "Boston Celtics",
                "Chicago Bulls",
                "Golden State Warriors"
            ),
            0
        ),
        QuizQuestion(
            "Basketball",
            1,
            "What is the diameter of a basketball hoop in inches?",
            listOf("16 inches", "17 inches", "18 inches"),
            2
        ),
        QuizQuestion(
            "Basketball",
            1,
            "Who is the all-time leading scorer in NBA history?",
            listOf("Michael Jordan", "LeBron James", "Kareem Abdul-Jabbar"),
            2
        ),
        QuizQuestion(
            "Basketball",
            1,
            "What is the name of the defensive strategy in basketball where defenders guard specific offensive players?",
            listOf("Zone defense", "Man-to-man defense", "Press defense"),
            1
        ),
        QuizQuestion(
            "Basketball",
            1,
            "What is the regulation height of a basketball hoop in feet?",
            listOf("9 feet", "10 feet", "11 feet"),
            1
        ),
        QuizQuestion(
            "Basketball",
            1,
            "Which player is known as 'The King' in basketball?",
            listOf("Michael Jordan", "LeBron James", "Kobe Bryant"),
            1
        ),
        QuizQuestion(
            "Basketball",
            1,
            "In what year was the NBA founded?",
            listOf("1946", "1950", "1954"),
            0
        ),
        QuizQuestion(
            "Basketball",
            1,
            "Which NBA team won the most consecutive championships?",
            listOf("Los Angeles Lakers", "Boston Celtics", "Chicago Bulls"),
            1
        ),
        QuizQuestion(
            "Basketball",
            1,
            "What is the term used for scoring three points with one shot in basketball?",
            listOf("Layup", "Dunk", "Three-pointer"),
            2
        ),
        QuizQuestion(
            "Basketball",
            1,
            "What is the name of the iconic basketball shoe line endorsed by Michael Jordan?",
            listOf("Adidas Superstar", "Puma Clyde", "Air Jordan"),
            2
        ),


        // Вопросы по категории "Basketball" и уровню 2
        QuizQuestion(
            "Basketball",
            2,
            "Who is known as the 'Black Mamba' in basketball?",
            listOf("Michael Jordan", "LeBron James", "Kobe Bryant"),
            2
        ),
        QuizQuestion(
            "Basketball",
            2,
            "How many players are on a standard basketball team?",
            listOf("4", "5", "6"),
            1
        ),
        QuizQuestion(
            "Basketball",
            2,
            "Who is the all-time leading assists leader in NBA history?",
            listOf("Magic Johnson", "John Stockton", "Jason Kidd"),
            1
        ),
        QuizQuestion(
            "Basketball",
            2,
            "What is the name of the legendary coach who led the Chicago Bulls to six NBA championships in the 1990s?",
            listOf("Pat Riley", "Phil Jackson", "Gregg Popovich"),
            1
        ),
        QuizQuestion(
            "Basketball",
            2,
            "Which player holds the record for the most points scored in a single NBA game?",
            listOf("Kobe Bryant", "Wilt Chamberlain", "Michael Jordan"),
            1
        ),
        QuizQuestion(
            "Basketball",
            2,
            "In what year was the three-point line introduced in the NBA?",
            listOf("1967", "1975", "1980"),
            2
        ),
        QuizQuestion(
            "Basketball",
            2,
            "Who is the all-time leading scorer in NCAA Men's Basketball Tournament history?",
            listOf("Christian Laettner", "Kareem Abdul-Jabbar", "Bill Walton"),
            0
        ),
        QuizQuestion(
            "Basketball",
            2,
            "Which NBA player is known for his signature 'Skyhook' shot?",
            listOf("Larry Bird", "Kareem Abdul-Jabbar", "Shaquille O'Neal"),
            1
        ),
        QuizQuestion(
            "Basketball",
            2,
            "What is the name of the arena where the Golden State Warriors play their home games?",
            listOf("Madison Square Garden", "Staples Center", "Chase Center"),
            2
        ),
        QuizQuestion(
            "Basketball",
            2,
            "Which player won the NBA MVP award in the 2020-2021 season?",
            listOf("LeBron James", "Giannis Antetokounmpo", "Nikola Jokic"),
            2
        ),


        // Вопросы по категории "Basketball" и уровню 3
        QuizQuestion(
            "Basketball",
            3,
            "Who is considered the greatest basketball player of all time?",
            listOf("Michael Jordan", "LeBron James", "Kobe Bryant"),
            0
        ),
        QuizQuestion(
            "Basketball",
            3,
            "How many NBA championships did the 'Showtime' Los Angeles Lakers win in the 1980s?",
            listOf("3", "4", "5"),
            1
        ),
        QuizQuestion(
            "Basketball",
            3,
            "Who is the all-time leading rebounder in NBA history?",
            listOf("Dennis Rodman", "Wilt Chamberlain", "Bill Russell"),
            0
        ),
        QuizQuestion(
            "Basketball",
            3,
            "Which team won the first-ever NBA Championship in 1947?",
            listOf("Philadelphia Warriors", "Chicago Stags", "Boston Celtics"),
            0
        ),
        QuizQuestion(
            "Basketball",
            3,
            "Which player won the NBA scoring title for the most seasons?",
            listOf("Karl Malone", "Michael Jordan", "Kobe Bryant"),
            0
        ),
        QuizQuestion(
            "Basketball",
            3,
            "What is the name of the iconic basketball shoe line endorsed by LeBron James?",
            listOf("Air Jordan", "Kobe Bryant's Signature Series", "LeBron James' LeBron Series"),
            2
        ),
        QuizQuestion(
            "Basketball",
            3,
            "Who was the first African American head coach in NBA history?",
            listOf("Red Auerbach", "Bill Russell", "Lenny Wilkens"),
            1
        ),
        QuizQuestion(
            "Basketball",
            3,
            "Which player is known for his nickname 'The Dream'?",
            listOf("Magic Johnson", "Kareem Abdul-Jabbar", "Hakeem Olajuwon"),
            2
        ),
        QuizQuestion(
            "Basketball",
            3,
            "What is the highest-scoring game in NBA history?",
            listOf("168-159", "186-184", "173-162"),
            1
        ),
        QuizQuestion(
            "Basketball",
            3,
            "Which player won the NBA Finals MVP the most times?",
            listOf("Michael Jordan", "Kobe Bryant", "LeBron James"),
            0
        ),


        // Вопросы по категории "Hockey" и уровню 1
        QuizQuestion(
            "Hockey",
            1,
            "Which NHL team has won the most Stanley Cup championships?",
            listOf(
                "Montreal Canadiens",
                "Toronto Maple Leafs",
                "Detroit Red Wings"
            ),
            0
        ),
        QuizQuestion(
            "Hockey",
            1,
            "How many players are on the ice for each team in a standard ice hockey game?",
            listOf("5 players", "6 players", "7 players"),
            0
        ),
        QuizQuestion(
            "Hockey",
            1,
            "Who is the all-time leading goal scorer for the Russian national hockey team?",
            listOf("Alexander Ovechkin", "Ilya Kovalchuk", "Pavel Bure"),
            0
        ),
        QuizQuestion(
            "Hockey",
            1,
            "What is the name of the championship trophy awarded to the NHL playoff winner?",
            listOf("Stanley Cup", "Calder Cup", "Vezina Trophy"),
            0
        ),
        QuizQuestion(
            "Hockey",
            1,
            "What is the name of the offensive zone area in ice hockey where the goal is located?",
            listOf("Neutral zone", "Defensive zone", "Offensive zone"),
            2
        ),
        QuizQuestion(
            "Hockey",
            1,
            "In what year did ice hockey become an official Olympic sport?",
            listOf("1908", "1920", "1932"),
            1
        ),
        QuizQuestion(
            "Hockey",
            1,
            "Who is the all-time leading scorer in NHL history?",
            listOf("Wayne Gretzky", "Mario Lemieux", "Gordie Howe"),
            0
        ),
        QuizQuestion(
            "Hockey",
            1,
            "Which player is known for his nickname 'The Great One'?",
            listOf("Wayne Gretzky", "Mario Lemieux", "Sidney Crosby"),
            0
        ),
        QuizQuestion(
            "Hockey",
            1,
            "What is the name of the protective gear that hockey players wear on their legs?",
            listOf("Gloves", "Helmet", "Pads"),
            2
        ),
        QuizQuestion(
            "Hockey",
            1,
            "Which country won the gold medal in men's ice hockey at the 2018 Winter Olympics?",
            listOf("Canada", "Russia", "Sweden"),
            1
        ),


        // Вопросы по категории "Hockey" и уровню 2
        QuizQuestion(
            "Hockey",
            2,
            "Which player is known as 'The Great Eight' in hockey?",
            listOf("Sidney Crosby", "Alexander Ovechkin", "Evgeni Malkin"),
            1
        ),
        QuizQuestion(
            "Hockey",
            2,
            "How many periods are there in a regulation ice hockey game?",
            listOf("2 periods", "3 periods", "4 periods"),
            1
        ),
        QuizQuestion(
            "Hockey",
            2,
            "Who is the all-time leading scorer for the Pittsburgh Penguins?",
            listOf("Mario Lemieux", "Sidney Crosby", "Jaromir Jagr"),
            0
        ),
        QuizQuestion(
            "Hockey",
            2,
            "What is the name of the award given to the NHL's top goaltender?",
            listOf("Vezina Trophy", "Hart Trophy", "Norris Trophy"),
            0
        ),
        QuizQuestion(
            "Hockey",
            2,
            "What is the name of the protective glass surrounding the hockey rink?",
            listOf("Dashers", "Boards", "Plexiglass"),
            1
        ),
        QuizQuestion(
            "Hockey",
            2,
            "Which player holds the record for the most career points in the NHL?",
            listOf("Wayne Gretzky", "Mario Lemieux", "Jaromir Jagr"),
            0
        ),
        QuizQuestion(
            "Hockey",
            2,
            "What is the name of the line change strategy in hockey where players quickly substitute to maintain a fast pace?",
            listOf("Forechecking", "Backchecking", "Dump and Chase"),
            2
        ),
        QuizQuestion(
            "Hockey",
            2,
            "Which NHL team won the Stanley Cup in the 2019-2020 season?",
            listOf("Tampa Bay Lightning", "Dallas Stars", "Vegas Golden Knights"),
            0
        ),
        QuizQuestion(
            "Hockey",
            2,
            "What is the term used for scoring three goals in a single game by one player?",
            listOf("Hat trick", "Slap shot", "Breakaway"),
            0
        ),
        QuizQuestion(
            "Hockey",
            2,
            "Which country won the gold medal in women's ice hockey at the 2018 Winter Olympics?",
            listOf("United States", "Canada", "Finland"),
            1
        ),


        // Вопросы по категории "Hockey" и уровню 3
        QuizQuestion(
            "Hockey",
            3,
            "Which player holds the record for the most goals scored in a single NHL season?",
            listOf("Wayne Gretzky", "Mario Lemieux", "Bobby Orr"),
            0
        ),
        QuizQuestion(
            "Hockey",
            3,
            "How many players are on the ice for each team during a power play in ice hockey?",
            listOf("4 players", "5 players", "6 players"),
            1
        ),
        QuizQuestion(
            "Hockey",
            3,
            "Who is the all-time leading scorer for the Detroit Red Wings?",
            listOf("Gordie Howe", "Steve Yzerman", "Nicklas Lidstrom"),
            1
        ),
        QuizQuestion(
            "Hockey",
            3,
            "What is the name of the award given to the NHL's most outstanding defenseman?",
            listOf("Hart Trophy", "Norris Trophy", "Vezina Trophy"),
            1
        ),
        QuizQuestion(
            "Hockey",
            3,
            "What is the term used for a player being removed from the ice for committing a penalty?",
            listOf("Time out", "Penalty shot", "Penalty box"),
            2
        ),
        QuizQuestion(
            "Hockey",
            3,
            "Which player won the Conn Smythe Trophy as the most valuable player in the NHL playoffs the most times?",
            listOf("Wayne Gretzky", "Mario Lemieux", "Patrick Roy"),
            2
        ),
        QuizQuestion(
            "Hockey",
            3,
            "What is the name of the line change strategy in hockey where players slowly substitute to control play?",
            listOf("Dump and Chase", "Forechecking", "Trap"),
            2
        ),
        QuizQuestion(
            "Hockey",
            3,
            "Which NHL team won the Stanley Cup in the 2015-2016 season?",
            listOf("Chicago Blackhawks", "Pittsburgh Penguins", "Los Angeles Kings"),
            1
        ),
        QuizQuestion(
            "Hockey",
            3,
            "What is the term used for a player scoring a goal immediately after leaving the penalty box?",
            listOf("Power play goal", "Short-handed goal", "Breakaway goal"),
            1
        ),
        QuizQuestion(
            "Hockey",
            3,
            "Which country won the gold medal in men's ice hockey at the 2014 Winter Olympics?",
            listOf("Sweden", "Canada", "Russia"),
            1
        ),


        // Вопросы по категории "Football" и уровню 1
        QuizQuestion(
            "Football",
            1,
            "Which country won the 2018 FIFA World Cup?",
            listOf("Brazil", "Germany", "France"),
            2
        ),
        QuizQuestion(
            "Football",
            1,
            "How many players are on the field for each team during a standard football match?",
            listOf("10 players", "11 players", "12 players"),
            1
        ),
        QuizQuestion(
            "Football",
            1,
            "Which club has won the most UEFA Champions League titles?",
            listOf("Real Madrid", "FC Barcelona", "Liverpool"),
            0
        ),
        QuizQuestion(
            "Football",
            1,
            "What is the name of the international football tournament held every four years for national teams?",
            listOf("UEFA Euro", "Copa America", "FIFA World Cup"),
            2
        ),
        QuizQuestion(
            "Football",
            1,
            "Which player has won the most Ballon d'Or awards?",
            listOf("Lionel Messi", "Cristiano Ronaldo", "Neymar"),
            0
        ),
        QuizQuestion(
            "Football",
            1,
            "What is the name of the football tournament played between English clubs?",
            listOf("La Liga", "Serie A", "Premier League"),
            2
        ),
        QuizQuestion(
            "Football",
            1,
            "Which country hosted the 2014 FIFA World Cup?",
            listOf("Brazil", "Germany", "Russia"),
            0
        ),
        QuizQuestion(
            "Football",
            1,
            "What is the name of the stadium that hosts the final of the UEFA Champions League?",
            listOf("Santiago Bernabeu", "Wembley Stadium", "Camp Nou"),
            1
        ),
        QuizQuestion(
            "Football",
            1,
            "Which player is often referred to as 'The King' of football?",
            listOf("Pele", "Diego Maradona", "Zinedine Zidane"),
            0
        ),
        QuizQuestion(
            "Football",
            1,
            "Which country won the UEFA Euro 2020?",
            listOf("France", "Portugal", "Italy"),
            2
        ),


        // Вопросы по категории "Football" и уровню 2
        QuizQuestion(
            "Football",
            2,
            "Which player holds the record for the most goals scored in a single UEFA Champions League season?",
            listOf("Cristiano Ronaldo", "Lionel Messi", "Robert Lewandowski"),
            2
        ),
        QuizQuestion(
            "Football",
            2,
            "How many minutes are played in each half of a standard football match?",
            listOf("30 minutes", "40 minutes", "45 minutes"),
            2
        ),
        QuizQuestion(
            "Football",
            2,
            "Which club won the UEFA Champions League in the 2018-2019 season?",
            listOf("FC Barcelona", "Liverpool", "Real Madrid"),
            1
        ),
        QuizQuestion(
            "Football",
            2,
            "What is the name of the annual award presented by FIFA to the best male player?",
            listOf("FIFA Best Men's Player", "Ballon d'Or", "FIFA World Player of the Year"),
            0
        ),
        QuizQuestion(
            "Football",
            2,
            "Which country won the Copa America 2019?",
            listOf("Brazil", "Argentina", "Chile"),
            0
        ),
        QuizQuestion(
            "Football",
            2,
            "What is the name of the football tournament played between Spanish clubs?",
            listOf("Premier League", "Serie A", "La Liga"),
            2
        ),
        QuizQuestion(
            "Football",
            2,
            "Which country hosted the 2016 UEFA Euro?",
            listOf("Portugal", "France", "Germany"),
            1
        ),
        QuizQuestion(
            "Football",
            2,
            "What is the name of the stadium that hosts the final of the FIFA World Cup?",
            listOf("Wembley Stadium", "Estadio Santiago Bernabeu", "Maracanã Stadium"),
            2
        ),
        QuizQuestion(
            "Football",
            2,
            "Which player is often referred to as the 'Prince' of football?",
            listOf("Ronaldinho", "Thierry Henry", "Zlatan Ibrahimovic"),
            0
        ),
        QuizQuestion(
            "Football",
            2,
            "Which country won the UEFA Euro 2016?",
            listOf("Germany", "Portugal", "Spain"),
            1
        ),


        // Вопросы по категории "Football" и уровню 3
        QuizQuestion(
            "Football",
            3,
            "Which player holds the record for the most goals scored in a single FIFA World Cup tournament?",
            listOf("Pele", "Just Fontaine", "Miroslav Klose"),
            2
        ),
        QuizQuestion(
            "Football",
            3,
            "How many players are on the field for each team during a penalty shootout?",
            listOf("4 players", "5 players", "6 players"),
            1
        ),
        QuizQuestion(
            "Football",
            3,
            "Which club has won the most English Premier League titles?",
            listOf("Manchester United", "Liverpool", "Arsenal"),
            0
        ),
        QuizQuestion(
            "Football",
            3,
            "What is the name of the international football tournament held every four years for women's national teams?",
            listOf("UEFA Women's Euro", "FIFA Women's World Cup", "Copa America Femenina"),
            1
        ),
        QuizQuestion(
            "Football",
            3,
            "Which player has won the most Ballon d'Or awards in history?",
            listOf("Lionel Messi", "Cristiano Ronaldo", "Michel Platini"),
            0
        ),
        QuizQuestion(
            "Football",
            3,
            "What is the name of the football tournament played between Italian clubs?",
            listOf("Serie A", "La Liga", "Bundesliga"),
            0
        ),
        QuizQuestion(
            "Football",
            3,
            "Which country hosted the 2010 FIFA World Cup?",
            listOf("Germany", "Brazil", "South Africa"),
            2
        ),
        QuizQuestion(
            "Football",
            3,
            "What is the name of the stadium that hosts the final of the UEFA European Championship?",
            listOf("Stade de France", "Allianz Arena", "Wembley Stadium"),
            2
        ),
        QuizQuestion(
            "Football",
            3,
            "Which player is often referred to as the 'Phenomenon' in football?",
            listOf("Ronaldo", "Ronaldinho", "Romario"),
            1
        ),
        QuizQuestion(
            "Football",
            3,
            "Which country won the FIFA Women's World Cup in 2019?",
            listOf("United States", "Sweden", "Germany"),
            0
        ),

        // Вопросы по категории "Karate" и уровню 1
        QuizQuestion(
            "Karate",
            1,
            "In which country did karate originate?",
            listOf("China", "Japan", "Korea"),
            1
        ),
        QuizQuestion(
            "Karate",
            1,
            "What does the word 'karate' mean in Japanese?",
            listOf("Empty hand", "Way of the warrior", "Harmony"),
            0
        ),
        QuizQuestion(
            "Karate",
            1,
            "What is the name for the white uniform worn in karate?",
            listOf("Gi", "Obi", "Hakama"),
            0
        ),
        QuizQuestion(
            "Karate",
            1,
            "Which part of the body is primarily used in karate striking techniques?",
            listOf("Feet", "Head", "Hands"),
            2
        ),
        QuizQuestion(
            "Karate",
            1,
            "What is the highest rank in karate?",
            listOf("Black belt", "Brown belt", "White belt"),
            0
        ),
        QuizQuestion(
            "Karate",
            1,
            "Which of the following is a basic karate stance?",
            listOf("Punching stance", "Kicking stance", "Horse stance"),
            2
        ),
        QuizQuestion(
            "Karate",
            1,
            "What is the name for the karate training hall?",
            listOf("Dojo", "Sensei", "Kata"),
            0
        ),
        QuizQuestion(
            "Karate",
            1,
            "Which of the following is a traditional karate weapon?",
            listOf("Bo staff", "Nunchaku", "Sai"),
            1
        ),
        QuizQuestion(
            "Karate",
            1,
            "Which type of karate focuses on throwing techniques?",
            listOf("Shotokan", "Kyokushin", "Judo"),
            2
        ),
        QuizQuestion(
            "Karate",
            1,
            "What is the Japanese term for a karate form or pattern of movements?",
            listOf("Kumite", "Kata", "Kihon"),
            1
        )
    )
}