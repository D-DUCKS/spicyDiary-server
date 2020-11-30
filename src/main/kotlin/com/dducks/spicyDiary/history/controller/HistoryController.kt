package com.dducks.spicyDiary.history.controller

import com.dducks.spicyDiary.history.domin.History
import com.dducks.spicyDiary.history.domin.HistoryNo
import com.dducks.spicyDiary.history.domin.HistorySubway
import com.dducks.spicyDiary.history.service.HistoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/history")
class HistoryController {
    @Autowired
    private lateinit var historyService: HistoryService

    @GetMapping("/{subwayId}")
    fun getHistorys(@PathVariable subwayId: String): ResponseEntity<*> {
        val historys = historyService.getHistorys(HistorySubway(subwayId))

        return ResponseEntity.ok(historys)
    }

    @GetMapping("/detail/{historyNo}")
    fun getDetailHistory(@PathVariable historyNo: Long): ResponseEntity<*> {
        val detailHistory = historyService.getDetailHistory(HistoryNo(historyNo));

        return ResponseEntity.ok(detailHistory)
    }

    @PostMapping
    fun registerHistory(@RequestBody history: History): ResponseEntity.BodyBuilder {
        historyService.registerHistory(history)

        return ResponseEntity.ok()
    }

    @PutMapping
    fun modifyHistory(@RequestBody history: History): ResponseEntity.BodyBuilder {
        historyService.modifyHistory(history)

        return ResponseEntity.ok()
    }

    @DeleteMapping("/{historyNo}")
    fun deleteHistory(@PathVariable historyNo: Long): ResponseEntity.BodyBuilder {
        historyService.deleteHistory(HistoryNo(historyNo))

        return ResponseEntity.ok()
    }
}