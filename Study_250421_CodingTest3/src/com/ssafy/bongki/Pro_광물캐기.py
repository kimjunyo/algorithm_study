def solution(picks, minerals):
    fatigue_table = {
        "diamond": [1, 5, 25],
        "iron":    [1, 1, 5],
        "stone":   [1, 1, 1]
    }

    # 곡괭이 개수만큼 광물 블록을 만든다
    blocks = []
    for i in range(0, len(minerals), 5):
        if len(blocks) == sum(picks):
            break
        blocks.append(minerals[i:i+5])

    # 각 블록의 "피로도 점수"를 계산 (stone 곡괭이 기준, 즉 가장 최악의 경우)
    def block_score(block):
        score = 0
        for mineral in block:
            if mineral == "diamond":
                score += 25
            elif mineral == "iron":
                score += 5
            else:
                score += 1
        return score

    # 피로도 높은 블록부터 처리
    blocks.sort(key=block_score, reverse=True)

    # 좋은 곡괭이 순으로 블록 처리
    total_fatigue = 0
    pick_order = [0] * picks[0] + [1] * picks[1] + [2] * picks[2]  
    # 0: 다이아, 1: 철, 2: 돌
    print(pick_order)

    for pick_type, block in zip(pick_order, blocks):
        for mineral in block:
            if mineral == "diamond":
                total_fatigue += fatigue_table["diamond"][pick_type]
            elif mineral == "iron":
                total_fatigue += fatigue_table["iron"][pick_type]
            else:
                total_fatigue += fatigue_table["stone"][pick_type]

    return total_fatigue
