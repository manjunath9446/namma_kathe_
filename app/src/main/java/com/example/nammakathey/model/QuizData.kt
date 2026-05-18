package com.example.nammakathey.model

data class QuizQuestion(
    val question: String,
    val questionKn: String,
    val options: List<String>,
    val optionsKn: List<String>,
    val correctIndex: Int
)

data class DistrictQuiz(
    val districtKey: String,
    val badgeName: String,
    val badgeNameKn: String,
    val badgeEmoji: String,
    val questions: List<QuizQuestion>
)

object QuizData {

    val quizzes = listOf(
        DistrictQuiz(
            districtKey = "Bagalkote",
            badgeName = "Stone Carver",
            badgeNameKn = "ಶಿಲ್ಪಕಲೆಗಾರ",
            badgeEmoji = "🏛️",
            questions = listOf(
                QuizQuestion("Which dynasty built the famous temples at Aihole and Pattadakal?",
                    "ಐಹೊಳೆ ಮತ್ತು ಪಟ್ಟದಕಲ್ಲಿನ ಪ್ರಸಿದ್ಧ ದೇವಾಲಯಗಳನ್ನು ನಿರ್ಮಿಸಿದವರು ಯಾರು?",
                    listOf("Hoysala", "Chalukya", "Vijayanagara", "Bahmani"),
                    listOf("ಹೊಯ್ಸಳ", "ಚಾಲುಕ್ಯ", "ವಿಜಯನಗರ", "ಬಹಮನಿ"), 1),
                QuizQuestion("What is Bagalkote often called due to its architecture?",
                    "ವಾಸ್ತುಶಿಲ್ಪದ ಕಾರಣದಿಂದಾಗಿ ಬಾಗಲಕೋಟೆಯನ್ನು ಹೆಚ್ಚಾಗಿ ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
                    listOf("Cradle of Temples", "Silk City", "Sugar Land", "Coffee Hub"),
                    listOf("ದೇವಾಲಯಗಳ ತೊಟ್ಟಿಲು", "ರೇಷ್ಮೆ ನಗರಿ", "ಸಕ್ಕರೆ ನಾಡು", "ಕಾಫಿ ಕೇಂದ್ರ"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Ballari",
            badgeName = "Hampi Guardian",
            badgeNameKn = "ಹಂಪಿ ರಕ್ಷಕ",
            badgeEmoji = "💎",
            questions = listOf(
                QuizQuestion("The Vijayanagara Empire rose from hills rich in which mineral?",
                    "ವಿಜಯನಗರ ಸಾಮ್ರಾಜ್ಯವು ಯಾವ ಖನಿಜದಿಂದ ಸಮೃದ್ಧವಾಗಿರುವ ಬೆಟ್ಟಗಳಿಂದ ಉದಯಿಸಿತು?",
                    listOf("Gold", "Copper", "Iron", "Silver"),
                    listOf("ಚಿನ್ನ", "ತಾಮ್ರ", "ಕಬ್ಬಿಣ", "ಬೆಳ್ಳಿ"), 2),
                QuizQuestion("Which UNESCO site in Ballari shows the empire's glory?",
                    "ಬಳ್ಳಾರಿಯ ಯಾವ ಯುನೆಸ್ಕೋ ತಾಣವು ಸಾಮ್ರಾಜ್ಯದ ವೈಭವವನ್ನು ತೋರಿಸುತ್ತದೆ?",
                    listOf("Hampi", "Bidar", "Belur", "Gokarna"),
                    listOf("ಹಂಪಿ", "ಬೀದರ್", "ಬೇಲೂರು", "ಗೋಕರ್ಣ"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Belagavi",
            badgeName = "Freedom Flame",
            badgeNameKn = "ಸ್ವಾತಂತ್ರ್ಯದ ಜ್ಯೋತಿ",
            badgeEmoji = "🔥",
            questions = listOf(
                QuizQuestion("In which year did Rani Chennamma fight the British?",
                    "ರಾಣಿ ಚೆನ್ನಮ್ಮ ಯಾವ ವರ್ಷದಲ್ಲಿ ಬ್ರಿಟಿಷರ ವಿರುದ್ಧ ಹೋರಾಡಿದರು?",
                    listOf("1857", "1824", "1947", "1799"),
                    listOf("1857", "1824", "1947", "1799"), 1),
                QuizQuestion("Rani Chennamma is from which place in Belagavi?",
                    "ರಾಣಿ ಚೆನ್ನಮ್ಮ ಬೆಳಗಾವಿಯ ಯಾವ ಸ್ಥಳಕ್ಕೆ ಸೇರಿದವರು?",
                    listOf("Kittur", "Hampi", "Keladi", "Udupi"),
                    listOf("ಕಿತ್ತೂರು", "ಹಂಪಿ", "ಕೆಳದಿ", "ಉಡುಪಿ"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Bengaluru Rural",
            badgeName = "Silk Keeper",
            badgeNameKn = "ರೇಷ್ಮೆ ರಕ್ಷಕ",
            badgeEmoji = "🦋",
            questions = listOf(
                QuizQuestion("Doddaballapura is famous for which craft?",
                    "ದೊಡ್ಡಬಳ್ಳಾಪುರವು ಯಾವ ಕಲೆಗೆ ಪ್ರಸಿದ್ಧಿಯಾಗಿದೆ?",
                    listOf("Pottery", "Silk Weaving", "Sandalwood Carving", "Bidriware"),
                    listOf("ಕುಂಬಾರಿಕೆ", "ರೇಷ್ಮೆ ನೇಯ್ಗೆ", "ಶ್ರೀಗಂಧದ ಕೆತ್ತನೆ", "ಬಿದ್ರಿ ಕಲೆ"), 1)
            )
        ),
        DistrictQuiz(
            districtKey = "Bengaluru Urban",
            badgeName = "Engineer's Star",
            badgeNameKn = "ಇಂಜಿನಿಯರ್ ನಕ್ಷತ್ರ",
            badgeEmoji = "⭐",
            questions = listOf(
                QuizQuestion("Which famous engineer's birthday is celebrated as Engineers' Day?",
                    "ಯಾವ ಪ್ರಸಿದ್ಧ ಇಂಜಿನಿಯರ್ ಜನ್ಮದಿನವನ್ನು ಇಂಜಿನಿಯರ್‌ಗಳ ದಿನವಾಗಿ ಆಚರಿಸಲಾಗುತ್ತದೆ?",
                    listOf("C.V. Raman", "Sir M. Visvesvaraya", "Homi Bhabha", "A.P.J. Abdul Kalam"),
                    listOf("ಸಿ.ವಿ. ರಾಮನ್", "ಸರ್ ಎಂ. ವಿಶ್ವೇಶ್ವರಯ್ಯ", "ಹೋಮಿ ಭಾಭಾ", "ಎ.ಪಿ.ಜೆ. ಅಬ್ದುಲ್ ಕಲಾಂ"), 1)
            )
        ),
        DistrictQuiz(
            districtKey = "Bidar",
            badgeName = "Bidri Artist",
            badgeNameKn = "ಬಿದ್ರಿ ಕಲಾಕಾರ",
            badgeEmoji = "🖤",
            questions = listOf(
                QuizQuestion("Bidriware involves inlaying which metal on black zinc?",
                    "ಬಿದ್ರಿ ಕಲೆಯು ಕಪ್ಪು ತವರಿನ ಮೇಲೆ ಯಾವ ಲೋಹವನ್ನು ಕೆತ್ತುವುದನ್ನು ಒಳಗೊಂಡಿದೆ?",
                    listOf("Gold", "Silver", "Copper", "Iron"),
                    listOf("ಚಿನ್ನ", "ಬೆಳ್ಳಿ", "ತಾಮ್ರ", "ಕಬ್ಬಿಣ"), 1)
            )
        ),
        DistrictQuiz(
            districtKey = "Chamarajanagar",
            badgeName = "Forest Warden",
            badgeNameKn = "ಅರಣ್ಯ ಪಾಲಕ",
            badgeEmoji = "🌿",
            questions = listOf(
                QuizQuestion("Which tribe is known as the guardians of the BR Hills?",
                    "ಬಿ.ಆರ್. ಬೆಟ್ಟದ ರಕ್ಷಕರೆಂದು ಯಾವ ಬುಡಕಟ್ಟು ಜನರನ್ನು ಕರೆಯಲಾಗುತ್ತದೆ?",
                    listOf("Soliga", "Kuruba", "Toda", "Irula"),
                    listOf("ಸೊಲಿಗ", "ಕುರುಬ", "ತೋಡ", "ಇರುಳ"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Chikkaballapura",
            badgeName = "Hilltop Dreamer",
            badgeNameKn = "ಬೆಟ್ಟದ ಕನಸುಗಾರ",
            badgeEmoji = "🌄",
            questions = listOf(
                QuizQuestion("Which hill was Tipu Sultan's summer retreat?",
                    "ಟಿಪ್ಪು ಸುಲ್ತಾನರ ಬೇಸಿಗೆ ತಾಣವಾಗಿದ್ದ ಬೆಟ್ಟ ಯಾವುದು?",
                    listOf("Nandi Hills", "Chamundi Hills", "Kemmangundi", "Kodachadri"),
                    listOf("ನಂದಿ ಬೆಟ್ಟ", "ಚಾಮುಂಡಿ ಬೆಟ್ಟ", "ಕೆಮ್ಮಣ್ಣುಗುಂಡಿ", "ಕೊಡಚಾದ್ರಿ"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Chikkamagaluru",
            badgeName = "Coffee Pioneer",
            badgeNameKn = "ಕಾಫಿ ಪ್ರವರ್ತಕ",
            badgeEmoji = "☕",
            questions = listOf(
                QuizQuestion("Who brought seven coffee beans to Chikkamagaluru?",
                    "ಚಿಕ್ಕಮಗಳೂರಿಗೆ ಏಳು ಕಾಫಿ ಬೀಜಗಳನ್ನು ತಂದವರು ಯಾರು?",
                    listOf("Baba Budan", "Kanaka Dasa", "Purandara Dasa", "Shishunala Sharif"),
                    listOf("ಬಾಬಾ ಬುಡನ್", "ಕನಕದಾಸರು", "ಪುರಂದರದಾಸರು", "ಶಿಶುನಾಳ ಶರೀಫರು"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Chitradurga",
            badgeName = "Brave Heart",
            badgeNameKn = "ವೀರ ಹೃದಯ",
            badgeEmoji = "🗡️",
            questions = listOf(
                QuizQuestion("What weapon did Onake Obavva use to fight?",
                    "ಒನಕೆ ಓಬವ್ವ ಹೋರಾಡಲು ಬಳಸಿದ ಆಯುಧ ಯಾವುದು?",
                    listOf("Sword", "Spear", "Pestle (Onake)", "Bow"),
                    listOf("ಕತ್ತಿ", "ಈಟಿ", "ಒನಕೆ", "ಬಿಲ್ಲು"), 2)
            )
        ),
        DistrictQuiz(
            districtKey = "Dakshina Kannada",
            badgeName = "Yaksha Star",
            badgeNameKn = "ಯಕ್ಷ ನಕ್ಷತ್ರ",
            badgeEmoji = "🎭",
            questions = listOf(
                QuizQuestion("Which folk art features elaborate makeup and towering crowns?",
                    "ಯಾವ ಜಾನಪದ ಕಲೆಯು ವಿಶಿಷ್ಟ ವೇಷಭೂಷಣ ಮತ್ತು ದೊಡ್ಡ ಕಿರೀಟಗಳನ್ನು ಹೊಂದಿದೆ?",
                    listOf("Dollu Kunitha", "Yakshagana", "Kamsale", "Veeragase"),
                    listOf("ಡೊಳ್ಳು ಕುಣಿತ", "ಯಕ್ಷಗಾನ", "ಕಂಸಾಲೆ", "ವೀರಗಾಸೆ"), 1)
            )
        ),
        DistrictQuiz(
            districtKey = "Davanagere",
            badgeName = "Cotton Warrior",
            badgeNameKn = "ಹತ್ತಿ ವೀರ",
            badgeEmoji = "🏴",
            questions = listOf(
                QuizQuestion("Davanagere is often called the 'Manchester of' which state?",
                    "ದಾವಣಗೆರೆಯನ್ನು ಯಾವ ರಾಜ್ಯದ 'ಮ್ಯಾಂಚೆಸ್ಟರ್' ಎಂದು ಕರೆಯಲಾಗುತ್ತದೆ?",
                    listOf("Tamil Nadu", "Karnataka", "Kerala", "Maharashtra"),
                    listOf("ತಮಿಳುನಾಡು", "ಕರ್ನಾಟಕ", "ಕೇರಳ", "ಮಹಾರಾಷ್ಟ್ರ"), 1)
            )
        ),
        DistrictQuiz(
            districtKey = "Dharwad",
            badgeName = "Music Legend",
            badgeNameKn = "ಸಂಗೀತ ದಂತಕಥೆ",
            badgeEmoji = "🎵",
            questions = listOf(
                QuizQuestion("Gangubai Hangal was a master of which music style?",
                    "ಗಂಗೂಬಾಯಿ ಹಾನಗಲ್ ಯಾವ ಸಂಗೀತ ಶೈಲಿಯಲ್ಲಿ ಪ್ರವೀಣರಾಗಿದ್ದರು?",
                    listOf("Carnatic", "Hindustani Classical", "Sufi", "Pop"),
                    listOf("ಕರ್ನಾಟಿಕ್", "ಹಿಂದೂಸ್ತಾನಿ ಶಾಸ್ತ್ರೀಯ", "ಸೂಫಿ", "ಪಾಪ್"), 1)
            )
        ),
        DistrictQuiz(
            districtKey = "Gadag",
            badgeName = "Temple Scholar",
            badgeNameKn = "ದೇವಾಲಯ ವಿದ್ವಾಂಸ",
            badgeEmoji = "🕌",
            questions = listOf(
                QuizQuestion("Which poet wrote 'Karnataka Bharata Kathamanjari' in Gadag?",
                    "ಗದಗಿನಲ್ಲಿ 'ಕರ್ನಾಟಕ ಭಾರತ ಕಥಾಮಂಜರಿ' ಬರೆದ ಕವಿ ಯಾರು?",
                    listOf("Pampa", "Ranna", "Kumaravyasa", "Janna"),
                    listOf("ಪಂಪ", "ರನ್ನ", "ಕುಮಾರವ್ಯಾಸ", "ಜನ್ನ"), 2)
            )
        ),
        DistrictQuiz(
            districtKey = "Hassan",
            badgeName = "Hoysala Heir",
            badgeNameKn = "ಹೊಯ್ಸಳ ವಾರಸುದಾರ",
            badgeEmoji = "🏯",
            questions = listOf(
                QuizQuestion("Belur and Halebidu are famous for which architecture?",
                    "ಬೇಲೂರು ಮತ್ತು ಹಳೇಬೀಡು ಯಾವ ವಾಸ್ತುಶಿಲ್ಪಕ್ಕೆ ಪ್ರಸಿದ್ಧವಾಗಿವೆ?",
                    listOf("Hoysala", "Chola", "Mughal", "British"),
                    listOf("ಹೊಯ್ಸಳ", "ಚೋಳ", "ಮೊಘಲ್", "ಬ್ರಿಟಿಷ್"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Haveri",
            badgeName = "Devotion Badge",
            badgeNameKn = "ಭಕ್ತಿ ಪದಕ",
            badgeEmoji = "🙏",
            questions = listOf(
                QuizQuestion("Kanakadasa was born in which place in Haveri?",
                    "ಕನಕದಾಸರು ಹಾವೇರಿಯ ಯಾವ ಸ್ಥಳದಲ್ಲಿ ಜನಿಸಿದರು?",
                    listOf("Kaginele", "Udupi", "Hampi", "Bankapura"),
                    listOf("ಕಾಗಿನೆಲೆ", "ಉಡುಪಿ", "ಹಂಪಿ", "ಬಂಕಪುರ"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Kalaburagi",
            badgeName = "Deccan Crown",
            badgeNameKn = "ಡೆಕ್ಕನ್ ಕಿರೀಟ",
            badgeEmoji = "👑",
            questions = listOf(
                QuizQuestion("Kalaburagi was the first capital of which Sultanate?",
                    "ಕಲಬುರಗಿ ಯಾವ ಸುಲ್ತಾನರ ಮೊದಲ ರಾಜಧಾನಿಯಾಗಿತ್ತು?",
                    listOf("Adil Shahi", "Bahmani", "Mughal", "Nizam"),
                    listOf("ಆದಿಲ್ ಶಾಹಿ", "ಬಹಮನಿ", "ಮೊಘಲ್", "ನಿಜಾಂ"), 1)
            )
        ),
        DistrictQuiz(
            districtKey = "Kodagu",
            badgeName = "Commander's Medal",
            badgeNameKn = "ಕಮಾಂಡರ್ ಪದಕ",
            badgeEmoji = "🎖️",
            questions = listOf(
                QuizQuestion("Who was the first Indian Commander-in-Chief from Kodagu?",
                    "ಕೊಡಗಿನಿಂದ ಬಂದ ಭಾರತದ ಮೊದಲ ಕಮಾಂಡರ್-ಇನ್-ಚೀಫ್ ಯಾರು?",
                    listOf("General Thimayya", "Field Marshal Cariappa", "Sam Manekshaw", "Arjan Singh"),
                    listOf("ಜನರಲ್ ತಿಮ್ಮಯ್ಯ", "ಫೀಲ್ಡ್ ಮಾರ್ಷಲ್ ಕಾರಿಯಪ್ಪ", "ಸ್ಯಾಮ್ ಮಾಣೆಕ್‌ಶಾ", "ಅರ್ಜನ್ ಸಿಂಗ್"), 1)
            )
        ),
        DistrictQuiz(
            districtKey = "Kolar",
            badgeName = "Gold Rush",
            badgeNameKn = "ಚಿನ್ನದ ನಾಡು",
            badgeEmoji = "🥇",
            questions = listOf(
                QuizQuestion("KGF is famous for mining which metal?",
                    "ಕೆಜಿಎಫ್ ಯಾವ ಲೋಹದ ಗಣಿಗಾರಿಕೆಗೆ ಪ್ರಸಿದ್ಧವಾಗಿದೆ?",
                    listOf("Iron", "Silver", "Gold", "Coal"),
                    listOf("ಕಬ್ಬಿಣ", "ಬೆಳ್ಳಿ", "ಚಿನ್ನ", "ಕಲ್ಲಿದ್ದಲು"), 2)
            )
        ),
        DistrictQuiz(
            districtKey = "Koppal",
            badgeName = "Heritage Keeper",
            badgeNameKn = "ಪರಂಪರೆಯ ರಕ್ಷಕ",
            badgeEmoji = "📜",
            questions = listOf(
                QuizQuestion("Koppal is known for which historic era connection?",
                    "ಕೊಪ್ಪಳ ಯಾವ ಐತಿಹಾಸಿಕ ಯುಗದ ಸಂಪರ್ಕಕ್ಕೆ ಹೆಸರುವಾಸಿಯಾಗಿದೆ?",
                    listOf("Vijayanagara", "British", "French", "Dutch"),
                    listOf("ವಿಜಯನಗರ", "ಬ್ರಿಟಿಷ್", "ಫ್ರೆಂಚ್", "ಡಚ್"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Mandya",
            badgeName = "Sugar Brave",
            badgeNameKn = "ಸಕ್ಕರೆ ವೀರ",
            badgeEmoji = "⚔️",
            questions = listOf(
                QuizQuestion("Who was the fearless general who hid in sugarcane fields?",
                    "ಸಕ್ಕರೆ ಗದ್ದೆಗಳಲ್ಲಿ ಅಡಗಿಕೊಂಡಿದ್ದ ನಿರ್ಭೀತ ಸೇನಾಧಿಪತಿ ಯಾರು?",
                    listOf("Sangolli Rayanna", "Tipu Sultan", "Hyder Ali", "Shivaji"),
                    listOf("ಸಂಗೊಳ್ಳಿ ರಾಯಣ್ಣ", "ಟಿಪ್ಪು ಸುಲ್ತಾನ್", "ಹೈದರ್ ಆಲಿ", "ಶಿವಾಜಿ"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Mysuru",
            badgeName = "Tiger Badge",
            badgeNameKn = "ಹುಲಿ ಪದಕ",
            badgeEmoji = "🐯",
            questions = listOf(
                QuizQuestion("Who is known as the 'Tiger of Mysore'?",
                    "ಯಾರನ್ನು 'ಮೈಸೂರು ಹುಲಿ' ಎಂದು ಕರೆಯಲಾಗುತ್ತದೆ?",
                    listOf("Wodeyar", "Tipu Sultan", "Kempe Gowda", "Cariappa"),
                    listOf("ಒಡೆಯರ್", "ಟಿಪ್ಪು ಸುಲ್ತಾನ್", "ಕೆಂಪೇಗೌಡ", "ಕಾರಿಯಪ್ಪ"), 1)
            )
        ),
        DistrictQuiz(
            districtKey = "Raichur",
            badgeName = "Fort Defender",
            badgeNameKn = "ಕೋಟೆ ರಕ್ಷಕ",
            badgeEmoji = "🛡️",
            questions = listOf(
                QuizQuestion("Raichur is situated between which two rivers?",
                    "ರಾಯಚೂರು ಯಾವ ಎರಡು ನದಿಗಳ ನಡುವೆ ಇದೆ?",
                    listOf("Krishna & Tungabhadra", "Kaveri & Kapila", "Netravati & Sharavati", "Malaprabha & Ghataprabha"),
                    listOf("ಕೃಷ್ಣಾ ಮತ್ತು ತುಂಗಭದ್ರಾ", "ಕಾವೇರಿ ಮತ್ತು ಕಪಿಲಾ", "ನೇತ್ರಾವತಿ ಮತ್ತು ಶರಾವತಿ", "ಮಲಪ್ರಭಾ ಮತ್ತು ಘಟಪ್ರಭಾ"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Ramanagara",
            badgeName = "Silk Royale",
            badgeNameKn = "ರೇಷ್ಮೆ ವೈಭವ",
            badgeEmoji = "🏅",
            questions = listOf(
                QuizQuestion("Which movie was shot in the boulders of Ramanagara?",
                    "ರಾಮನಗರದ ಬೆಟ್ಟಗಳಲ್ಲಿ ಯಾವ ಚಿತ್ರದ ಚಿತ್ರೀಕರಣ ನಡೆಯಿತು?",
                    listOf("Sholay", "Lagaan", "Baahubali", "KGF"),
                    listOf("ಶೋಲೆ", "ಲಗಾನ್", "ಬಾಹುಬಲಿ", "ಕೆಜಿಎಫ್"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Shivamogga",
            badgeName = "Royal Protector",
            badgeNameKn = "ರಾಜವಂಶ ರಕ್ಷಕ",
            badgeEmoji = "🤝",
            questions = listOf(
                QuizQuestion("Which queen gave shelter to Chhatrapati Rajaram?",
                    "ಛತ್ರಪತಿ ರಾಜಾರಾಮನಿಗೆ ಆಶ್ರಯ ನೀಡಿದ ರಾಣಿ ಯಾರು?",
                    listOf("Kittur Chennamma", "Keladi Chennamma", "Abbakka Chowta", "Obavva"),
                    listOf("ಕಿತ್ತೂರು ಚೆನ್ನಮ್ಮ", "ಕೆಳದಿ ಚೆನ್ನಮ್ಮ", "ಅಬ್ಬಕ್ಕ ಚೌಟ", "ಓಬವ್ವ"), 1)
            )
        ),
        DistrictQuiz(
            districtKey = "Tumakuru",
            badgeName = "Folk Keeper",
            badgeNameKn = "ಜಾನಪದ ರಕ್ಷಕ",
            badgeEmoji = " drum",
            questions = listOf(
                QuizQuestion("Which dance involves clashing cymbals and spinning?",
                    "ಯಾವ ನೃತ್ಯವು ತಾಳಗಳನ್ನು ಬಡಿಯುವುದು ಮತ್ತು ಗಿರಕಿ ಹೊಡೆಯುವುದನ್ನು ಒಳಗೊಂಡಿದೆ?",
                    listOf("Kamsale", "Dollu Kunitha", "Kolata", "Suggi Kunitha"),
                    listOf("ಕಂಸಾಲೆ", "ಡೊಳ್ಳು ಕುಣಿತ", "ಕೋಲಾಟ", "ಸುಗ್ಗಿ ಕುಣಿತ"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Udupi",
            badgeName = "Krishna's Blessing",
            badgeNameKn = "ಕೃಷ್ಣನ ಆಶೀರ್ವಾದ",
            badgeEmoji = "🪄",
            questions = listOf(
                QuizQuestion("The famous Krishna Mutt was founded by whom?",
                    "ಪ್ರಸಿದ್ಧ ಕೃಷ್ಣ ಮಠವನ್ನು ಸ್ಥಾಪಿಸಿದವರು ಯಾರು?",
                    listOf("Shankara", "Madhvacharya", "Ramanuja", "Basavanna"),
                    listOf("ಶಂಕರ", "ಮಧ್ವಾಚಾರ್ಯ", "ರಾಮಾನುಜ", "ಬಸವಣ್ಣ"), 1)
            )
        ),
        DistrictQuiz(
            districtKey = "Uttara Kannada",
            badgeName = "Sea Voyager",
            badgeNameKn = "ಸಮುದ್ರಯಾನಿ",
            badgeEmoji = "⚓",
            questions = listOf(
                QuizQuestion("Uttara Kannada is known for which religious forest retreat?",
                    "ಉತ್ತರ ಕನ್ನಡವು ಯಾವ ಧಾರ್ಮಿಕ ಅರಣ್ಯ ತಾಣಕ್ಕೆ ಹೆಸರುವಾಸಿಯಾಗಿದೆ?",
                    listOf("Gokarna", "Hampi", "Mysuru", "Bidar"),
                    listOf("ಗೋಕರ್ಣ", "ಹಂಪಿ", "ಮೈಸೂರು", "ಬೀದರ್"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Vijayapura",
            badgeName = "Dome Master",
            badgeNameKn = "ಗುಮ್ಮಟದ ಒಡೆಯ",
            badgeEmoji = "🕍",
            questions = listOf(
                QuizQuestion("What is unique about the Gol Gumbaz gallery?",
                    "ಗೋಲ್ ಗುಮ್ಮಟದ ಗ್ಯಾಲರಿಯ ವಿಶೇಷತೆ ಏನು?",
                    listOf("Echoes 7 times", "Silent Gallery", "Glass floor", "Gold walls"),
                    listOf("7 ಬಾರಿ ಪ್ರತಿಧ್ವನಿಸುತ್ತದೆ", "ಮೌನ ಗ್ಯಾಲರಿ", "ಗಾಜಿನ ನೆಲ", "ಚಿನ್ನದ ಗೋಡೆಗಳು"), 0)
            )
        ),
        DistrictQuiz(
            districtKey = "Yadgir",
            badgeName = "Ancient Keeper",
            badgeNameKn = "ಪ್ರಾಚೀನ ರಕ್ಷಕ",
            badgeEmoji = "🗺️",
            questions = listOf(
                QuizQuestion("Yadgir Fort overlooks which river?",
                    "ಯಾದಗಿರಿ ಕೋಟೆ ಯಾವ ನದಿಯ ಮೇಲಿದೆ?",
                    listOf("Kaveri", "Krishna", "Netravati", "Ghataprabha"),
                    listOf("ಕಾವೇರಿ", "ಕೃಷ್ಣಾ", "ನೇತ್ರಾವತಿ", "ಘಟಪ್ರಭಾ"), 1)
            )
        ),
        DistrictQuiz(
            districtKey = "Vijayanagara",
            badgeName = "Golden Era Badge",
            badgeNameKn = "ಸುವರ್ಣ ಯುಗದ ಪದಕ",
            badgeEmoji = "🌟",
            questions = listOf(
                QuizQuestion("Who was the most famous king of the Vijayanagara Empire?",
                    "ವಿಜಯನಗರ ಸಾಮ್ರಾಜ್ಯದ ಅತ್ಯಂತ ಪ್ರಸಿದ್ಧ ರಾಜ ಯಾರು?",
                    listOf("Devaraya I", "Krishnadevaraya", "Harihara", "Bukka"),
                    listOf("ಮೊದಲ ದೇವರಾಯ", "ಕೃಷ್ಣದೇವರಾಯ", "ಹರಿಹರ", "ಬುಕ್ಕ"), 1)
            )
        )
    )

    fun getQuizForDistrict(districtName: String): DistrictQuiz? {
        return quizzes.find { it.districtKey == districtName }
    }
}