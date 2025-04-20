from collections import defaultdict
def solution(genres, plays):
    """
    장르 별로 가장 많이 재생된 노래 2개씩 베스트 고로 장르 개수를 선택
    
    1. 장르를 먼저 수록 장르합 장르부터 배열
    2. 장르 내에서 배열
    3. 다 같으면 고유번호가 낮은 애부터 수록
    
    i가 최대 만개임.
    
    입력: 장르 배열과 재생횟수배열 play 
    출력: 고유번호(배열인덱스) 리턴
    
    
    """
    # 장르별 총 재생 수, 장르별 곡 정보
    genre_play_count = defaultdict(int)
    genre_to_songs = defaultdict(list)

    # 곡 정보 수집
    for i, (genre, play) in enumerate(zip(genres, plays)):
        genre_play_count[genre] += play
        genre_to_songs[genre].append((play, i))

    # 장르별 총 재생 수로 정렬
    sorted_genres = sorted(genre_play_count.keys(), key=lambda g: genre_play_count[g], reverse=True)

    answer = []
    for genre in sorted_genres:
        # 각 장르의 곡들을 (재생 수 내림차순 -> 절대값 -로붙여서, 고유번호 오름차순)으로 정렬
        songs = sorted(genre_to_songs[genre], key=lambda x: (-x[0], x[1]))
        # 최대 2개만 선택
        answer.extend([i for c, i in songs[:2]])

    return answer
