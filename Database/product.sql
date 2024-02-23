
SELECT P.PDNAME, P.PDSUBNAME, F.FACNAME, ST.STONAME, S.STAMOUNT
FROM PRODUCT P
JOIN STOCK S ON P.PDNO = S.PDNO
JOIN STORE ST ON S.STONO = ST.STONO
JOIN FACTORY F ON P.FACTNO = F.FACTNO
WHERE F.FACLOC = 'SEOUL' AND (S.STAMOUNT = 0 OR (ifnull(S.STAMOUNT,0)))
ORDER BY 1;