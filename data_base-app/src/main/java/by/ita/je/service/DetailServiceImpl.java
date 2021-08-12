package by.ita.je.service;

import by.ita.je.dao.DetailDao;
import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Detail;
import by.ita.je.service.api.ServiceDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class DetailServiceImpl implements ServiceDetail {

    private final DetailDao detailDao;

    @Override
    public Detail create(Detail detail) throws NotCorrectData {
        if(detail.getName()==null) throw new NotCorrectData("Not correct data NAME_DETAIL");
        detail.setNotes("Хороша запчасть!!!!)))");
        detail.setSellingPrice(Math.random()*25);
        detail.setDataTimeDelivery(ZonedDateTime.now().plusDays(2));
        return detailDao.save(detail);
    }

    @Override
    public Detail findById(Long id) throws NotFoundData {
        final Detail detail= detailDao.findById(id)
                .orElseThrow(() -> new NotFoundData(id + " not found"));
        return detail;
    }

    @Override
    public List<Detail> readByIDs(List<Long> listIds) {
        List<Detail> listDetail=(List<Detail>) detailDao.findAllById(listIds);
        return listDetail;
    }

    @Override
    public List<Detail> readAll() {
        final Spliterator<Detail> result = detailDao.findAll().spliterator();
        return StreamSupport
                .stream(result, false)
                .collect(Collectors.toList());
    }

    @Override
    public Detail update(Long id, Detail detailNew) throws NotFoundData {
        final Detail detail = detailDao.findById(id)
                .orElseThrow(() -> new NotFoundData(id + " not found"));
        if(detailNew.getName()!="") detailNew.setName(detailNew.getName());
        if(detailNew.getPartNumber()!=0) detail.setPartNumber(detailNew.getPartNumber());
        if(detailNew.getPurchasePrice()!=0) detail.setPurchasePrice(detailNew.getPurchasePrice());
        if(detailNew.getExtraCharge()!=0) detail.setExtraCharge(detailNew.getExtraCharge());
        return detailDao.save(detail);
    }

    @Override
    public void deleteById(Long id) throws NotFoundData{
        try {
            detailDao.deleteById(id);
        }catch (Exception e){
            throw new NotFoundData(id + " not found");
        }
    }

    @Override
    public void deleteList(List<Long> listIds){
        detailDao.deleteAllById(listIds);
    }
}
