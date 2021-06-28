package com.umbrella.tab.ui.tab.viewpager

data class Places(val title: String, val description: String, val rating: Float, val url: String)

val places = listOf(
    Places(
        "Tuvalu",
        "Tuvalu, in the South Pacific, is an independent island nation within the British Commonwealth. Its 9 islands comprise small, thinly populated atolls and reef islands with palm-fringed beaches and WWII sites.",
        5f,
        "https://images.unsplash.com/photo-1483683804023-6ccdb62f86ef?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=675&q=80"
    ),
    Places(
        "Los Angles",
        "Los Angeles is a sprawling Southern California city and the center of the nation’s film and television industry. Near its iconic Hollywood sign, studios such as Paramount Pictures, Universal and Warner Brothers offer behind-the-scenes tours.",
        4.5f,
        "https://images.unsplash.com/photo-1554143091-c41d76e3da15?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=675&q=80"
    ),
    Places(
        "China",
        "China, officially the People's Republic of China, is a country in East Asia and is the world's most populous country, with a population of around 1.428 billion in 2017.",
        4.5f,
        "https://images.unsplash.com/photo-1529921879218-f99546d03a9d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=675&q=80"
    ),
    Places(
        "Tokyo",
        "Tokyo, Japan’s busy capital, mixes the ultramodern and the traditional, from neon-lit skyscrapers to historic temples. The opulent Meiji Shinto Shrine is known for its towering gate and surrounding woods.",
        3.5f,
        "https://images.unsplash.com/photo-1540959733332-eab4deabeeaf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1071&q=80"
    )
)
