package by.ita.je.service;

import by.ita.je.dao.api.PositionDao;
import by.ita.je.dao.api.WorkerDao;
import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Position;
import by.ita.je.model.Worker;
import by.ita.je.model.enums.Status;
import by.ita.je.service.api.ServiceWorker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class WorkerServiceImpl implements ServiceWorker {
    private final WorkerDao workerDao;
    private final PositionDao positionDao;

    @Override
    public Worker create(Worker worker) throws NotCorrectData {
        if(worker.getSecondName()==null) throw new NotCorrectData("Not correct data NAME_WORKER");
        worker.setSalary(BigDecimal.valueOf((long) (Math.random()*1000)));
        worker.setDataTimeStartWork(ZonedDateTime.now().minusYears((long) (Math.random()*10)));

        return workerDao.save(worker);
    }

    @Override
    public Worker findById(Long id) throws NotFoundData {
        final Worker worker= workerDao.findById(id)
                .orElseThrow(() -> new NotFoundData(id + " not found"));
        return worker;
    }

    @Override
    public List<Worker> readByIDs(List<Long> listIds) {
        List<Worker> listWorker=(List<Worker>) workerDao.findAllById(listIds);
        return listWorker;
    }

    @Override
    public List<Worker> readAll() {
        final Spliterator<Worker> result = workerDao.findAll().spliterator();
        return StreamSupport
                .stream(result, false)
                .collect(Collectors.toList());
    }

    @Override
    public Worker update(Long id, Worker workerNew) throws NotFoundData {
        final Worker worker = workerDao.findById(id)
                .orElseThrow(() -> new NotFoundData(id + " not found"));
        if(workerNew.getFirstName()!="") worker.setFirstName(workerNew.getFirstName());
        if(workerNew.getSecondName()!="") worker.setSecondName(workerNew.getSecondName());
        if(workerNew.getPhoneNumber()!=0) worker.setPhoneNumber(workerNew.getPhoneNumber());
        if(workerNew.getBonus()!=0) worker.setBonus(workerNew.getBonus());
        return workerDao.save(workerNew);
    }

    @Override
    public void deleteById(Long id)throws NotFoundData {
        try {
            workerDao.deleteById(id);
        }catch (Exception e){
            throw new NotFoundData(id + " not found");
        }
    }

    @Override
    public void deleteList(List<Long> listIds){
        workerDao.deleteAllById(listIds);
    }
}
